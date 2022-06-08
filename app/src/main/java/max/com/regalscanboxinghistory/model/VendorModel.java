package max.com.regalscanboxinghistory.model;

import android.os.Parcel;
import android.os.Parcelable;

import max.com.regalscanboxinghistory.contract.VendorContract;

/**
 * 筆記 :
 *  1.  向資料庫 或 後端請求
 */
public class VendorModel implements VendorContract.Model, Parcelable {
    String num;
    String qty;

    public VendorModel(String num, String qty) {
        this.num = num;
        this.qty = qty;
    }

    public VendorModel() {
    }

    protected VendorModel(Parcel in) {
        num = in.readString();
        qty = in.readString();
    }

    public static final Creator<VendorModel> CREATOR = new Creator<VendorModel>() {
        @Override
        public VendorModel createFromParcel(Parcel in) {
            return new VendorModel(in);
        }

        @Override
        public VendorModel[] newArray(int size) {
            return new VendorModel[size];
        }
    };

    @Override
    public String getNum() {
        return num;
    }

    @Override
    public String getQTY() {
        return qty;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(num);
        dest.writeString(qty);
    }
}
