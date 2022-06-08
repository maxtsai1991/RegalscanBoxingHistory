package max.com.regalscanboxinghistory.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import max.com.regalscanboxinghistory.R;
import max.com.regalscanboxinghistory.contract.VendorContract;

/**
 * 筆記 :
 *  1.  View 畫面 和 元件 處理
 *  2.  View不直接與Model交互，而是通過與Presenter交互來與Model間接交互
 */
public class BoxingActivity extends AppCompatActivity implements VendorContract.View {
    /**
     * 返回主選單 , 進入裝箱作業-工作歷程(歷程記錄)
     */
    private ImageView iv_back_main, iv_to_history;
    private String vendorName = "帝商";
    /**
     * 供應商名稱
     */
    private TextView tv_vendor_boxing;
    /**
     * 條碼資訊(號碼) , 數量
     */
    private EditText et_num, et_quantity;
    /**
     * CheckBox(手動/自動)
     */
    private CheckBox cb_no_auto;
    /**
     * 列印
     */
    private Button bt_print;
    /**
     * EditText輸入[號碼]轉字串
     */
    private String inputNumStr;
    /**
     * EditText輸入[數量]轉字串
     */
    private String inputQTYStr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boxing);
        findViews();
        handleClickListener();

    }

    private void findViews() {
        // 返回主選單
        iv_back_main = findViewById(R.id.iv_back_main);
        // 進入裝箱作業-工作歷程(歷程記錄)
        iv_to_history = findViewById(R.id.iv_to_history);
        // 條碼資訊(號碼)
        et_num = findViewById(R.id.et_num);
        // 數量
        et_quantity = findViewById(R.id.et_quantity);
        // 手動
        cb_no_auto = (CheckBox) findViewById(R.id.cb_no_auto);
        // 列印
        bt_print = findViewById(R.id.bt_print);
        // 供應商
        tv_vendor_boxing = findViewById(R.id.tv_vendor_boxing);
    }

    private void handleClickListener() {
        /**
         * 跳轉下一頁(歷程記錄)
         */
        iv_to_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BoxingActivity.this, HistoryActivity.class);
                startActivity(intent);
            }
        });

        /**
         * 列印 : 暫時先取得三種資料 : 供應商 號碼 數量
         */
        bt_print.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        /**
         *  et_num EditText【號碼】監聽事件
         */
        et_num.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN){
                    inputNumStr = et_num.getText().toString().trim();       // EditText輸入[號碼]轉字串
                    onSuccess("輸入號碼 : " + inputNumStr);
                    return true;
                }
                return false; //回傳 false 表示到這邊結束，回傳 true 則會繼續原本 onKey 定義的動作。
            }
        });

        /**
         *  et_quantity EditText【數量】監聽事件
         */
        et_quantity.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN){
                    inputQTYStr = et_quantity.getText().toString().trim();  // EditText輸入[數量]轉字串
                    onSuccess("輸入數量 :" + inputQTYStr);


                    /**
                     * 隱藏鍵盤
                     */
                    InputMethodManager inputMethodManager = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                    if(inputMethodManager.isActive()){
                        inputMethodManager.hideSoftInputFromWindow(BoxingActivity.this.getCurrentFocus().getWindowToken(),0);
                    }
                    return true;
                }
                return false; //回傳 false 表示到這邊結束，回傳 true 則會繼續原本 onKey 定義的動作。
            }
        });

        /**
         * Checkbox(手動/自動) 自動(isChecked = false)
         */
        cb_no_auto.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    onManualModeInfo("【手動】");
                }else {
                    onAutoModeInfo("【自動】");
                }

            }
        });




    }

    @Override
    public void onSuccess(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAutoModeInfo(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onManualModeInfo(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
