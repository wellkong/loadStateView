package com.willkong.loadsir.target;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.willkong.loadstate.R;

/**
 * Description:TODO
 * Create Time:2017/9/29 13:54
 */
public class BestPracticesActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_best_practices);
    }

    public void mvpActivity(View view) {
    }

    public void onLottie(View view) {
        startActivity(new Intent(this, LottieActivity.class));
    }
}
