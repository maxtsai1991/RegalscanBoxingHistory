package max.com.regalscanboxinghistory.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import max.com.regalscanboxinghistory.R;
import max.com.regalscanboxinghistory.contract.MainActivityContract;
import max.com.regalscanboxinghistory.presenter.MainActivityPresenter;

public class MainActivity extends AppCompatActivity implements MainActivityContract.View {
    EditText email,password;
    Button btn_login;
    TextView tv_String;
    MainActivityContract.Presenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**
         * presenter
         */
        presenter = new MainActivityPresenter(this);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        btn_login = findViewById(R.id.btn_login);
        tv_String = findViewById(R.id.tv_String);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String emailStr = email.getText().toString();
                String passwordStr = password.getText().toString();

                if(TextUtils.isEmpty(emailStr) || TextUtils.isEmpty(passwordStr)){
                }else{
                    presenter.doLogin(emailStr,passwordStr);

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




}