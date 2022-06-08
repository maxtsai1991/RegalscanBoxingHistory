package max.com.regalscanboxinghistory.presenter;

import android.database.Cursor;
import android.util.Log;

import com.regalscan.regalutilitylib.DBHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import max.com.regalscanboxinghistory.contract.VendorContract;
import max.com.regalscanboxinghistory.model.VendorModel;

/**
 * 筆記 :
 *  1.  Presenter則是擔任View及Model之間的橋樑
 *  2.  Presenter則是負責 邏輯和判斷
 *  3.  Presenter與View的交互是通過接口來進行的
 */
public class VendorPresenter implements VendorContract.Presenter {

    VendorContract.View view;
    ArrayList<VendorModel> vendorModelArrayList;
    VendorModel vendorModel;
    private DBHelper dbHelper;
    private String TABLE_NAME = "Settings";
    private String VENDOR_NAME ;

    public VendorPresenter(VendorContract.View view) {
        this.view = view;
        vendorModelArrayList = new ArrayList<>();
    }


    /**
     * 判斷是否同號碼,同號碼則將數量累加 (自動模式)
     */
    @Override
    public ArrayList<VendorModel> autoModeNumJudge(String inputNumStr, String inputQTYStr) {
        vendorModel = new VendorModel();
        vendorModel.setNum(inputNumStr);
        vendorModel.setQty(inputQTYStr);
        vendorModelArrayList.add(vendorModel);

        Map<String, VendorModel> map = new HashMap<>();
        try{
            for (VendorModel vendorModel1 : vendorModelArrayList){
                if(map.containsKey(vendorModel1.getNum())){
                    VendorModel oldVendorModel = map.get(vendorModel1.getNum());
                    int sumQTY = Integer.parseInt(oldVendorModel.getQTY()) + Integer.parseInt(vendorModel1.getQTY());
                    String sumQTYStr = String.valueOf(sumQTY);
                    oldVendorModel.setQty(sumQTYStr);
                    int lastIdx = vendorModelArrayList.size() -1;
                    VendorModel lastElement = vendorModelArrayList.get(lastIdx);
                    vendorModelArrayList.remove(lastElement);
                    vendorModelArrayList.add(oldVendorModel);
                }else {
                    map.put(vendorModel1.getNum(), new VendorModel(vendorModel1.getNum(),vendorModel1.getQTY()));
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return vendorModelArrayList;
    }

    /**
     * 手動模式
     */
    @Override
    public ArrayList<VendorModel> manualMode(String inputNumStr, String inputQTYStr) {
        vendorModel = new VendorModel();
        vendorModel.setNum(inputNumStr);
        vendorModel.setQty(inputQTYStr);
        vendorModelArrayList.add(vendorModel);
        return vendorModelArrayList;
    }

    @Override
    public String dbVendorNameInfo() {
        try {
            Cursor cursor1 = dbHelper.query("SELECT * FROM" + TABLE_NAME);
            if (cursor1 != null && cursor1.getCount() >= 0) {
                while (cursor1.moveToNext()) {
                    VENDOR_NAME = cursor1.getString(cursor1.getColumnIndexOrThrow("VENDOR_NAME"));
                    dbHelper.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return VENDOR_NAME;
    }


}
