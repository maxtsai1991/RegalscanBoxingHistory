package max.com.regalscanboxinghistory.presenter;

import max.com.regalscanboxinghistory.contract.MainActivityContract;

public class MainActivityPresenter implements MainActivityContract.Presenter {

    MainActivityContract.View view;

    public MainActivityPresenter(MainActivityContract.View view) {
        this.view = view;
    }

    @Override
    public void doLogin(String email, String password) {
        // email test
        // password 123
        if(email.equals("test") && password.equals("123")){
            view.onSuccess("登入成功");

        }else{
            view.onError("email 或 密碼錯誤");
        }
    }
}
