package max.com.regalscanboxinghistory.presenter;

import max.com.regalscanboxinghistory.contract.VendorContract;

/**
 * 筆記 :
 *  1.  Presenter則是擔任View及Model之間的橋樑
 *  2.  Presenter則是負責 邏輯和判斷
 *  3.  Presenter與View的交互是通過接口來進行的
 */
public class VendorPresenter implements VendorContract.Presenter {

    VendorContract.View view;

    public VendorPresenter(VendorContract.View view) {
        this.view = view;
    }


    @Override
    public void boxingInfoNum(String num) {

    }

    @Override
    public void boxingInfoQTY(String quantity) {

    }


}
