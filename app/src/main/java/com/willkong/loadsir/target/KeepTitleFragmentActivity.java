package com.willkong.loadsir.target;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

import com.willkong.loadstate.R;

/**
 * Description:
 * Create Time:2017/9/4 10:56
 */

public class KeepTitleFragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_fragment_single);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        getSupportFragmentManager().beginTransaction().add(R.id.fl_content, new KeepTitleFragment()).commit();
    }


}
