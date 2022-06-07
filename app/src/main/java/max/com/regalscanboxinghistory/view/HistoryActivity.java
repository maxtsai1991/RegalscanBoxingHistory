package max.com.regalscanboxinghistory.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import max.com.regalscanboxinghistory.R;

public class HistoryActivity extends AppCompatActivity {
    /**
     * 返回到裝箱作業
     */
    private View iv_return_boxing;
    /**
     * 供應商
     */
    private TextView tv_vendor_name_history;
    /**
     * Recyclerview id
     */
    private RecyclerView rv_info_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        findViews();
        handleClickListener();
    }

    private void findViews() {
        iv_return_boxing = findViewById(R.id.iv_return_boxing);
        tv_vendor_name_history = findViewById(R.id.tv_vendor_name_history);
        rv_info_list = findViewById(R.id.rv_info_list);
    }

    private void handleClickListener() {
        /**
         * 返回到裝箱作業
         */
        iv_return_boxing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HistoryActivity.this, BoxingActivity.class);
                startActivity(intent);
            }
        });


    }

}