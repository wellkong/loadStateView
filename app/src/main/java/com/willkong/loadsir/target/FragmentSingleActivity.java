package com.willkong.loadsir.target;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.willkong.loadstate.R;

/**
 * Description:TODO
 * Create Time:2017/9/4 10:56
 */

public class FragmentSingleActivity extends AppCompatActivity {
    private static final String TAG = "FragmentSingleActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_single);
        getSupportFragmentManager().beginTransaction().add(R.id.fl_content, new NormalFragment()).commit();

    }


}
