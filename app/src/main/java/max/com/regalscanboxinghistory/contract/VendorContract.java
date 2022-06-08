package max.com.regalscanboxinghistory.contract;

/**
 * 筆記 :
 *  1.   Contract類別，主要是定義View及Presenter之間互動的Interface層
 */
public interface VendorContract {
    interface Model {
    }

    interface View {
        void onSuccess(String message);
        void onError(String message);

        void onAutoModeInfo(String message);
        void onManualModeInfo(String message);

    }

    interface Presenter {
        void boxingInfoNum(String num);
        void boxingInfoQTY(String quantity);



    }

}
