package max.com.regalscanboxinghistory.contract;

import java.util.ArrayList;

import max.com.regalscanboxinghistory.model.VendorModel;

/**
 * 筆記 :
 *  1.   Contract類別，主要是定義View及Presenter之間互動的Interface層
 */
public interface VendorContract {
    interface Model {
        String getNum();
        String getQTY();
    }

    interface View {
        void onSuccess(String message);
        void onError(String message);

        void onAutoModeInfo(String message);
        void onManualModeInfo(String message);

        void onPrintInfo(String message);

    }

    interface Presenter {
        /**
         * 判斷是否同號碼,同號碼則將數量累加 (自動模式)
         */
        ArrayList<VendorModel> autoModeNumJudge(String inputNumStr, String inputQTYStr);
        String dbVendorNameInfo();
        /**
         * 手動模式
         */
        ArrayList<VendorModel> manualMode(String inputNumStr, String inputQTYStr);
    }

}
