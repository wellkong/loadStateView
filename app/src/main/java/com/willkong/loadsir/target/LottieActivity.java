package com.willkong.loadsir.target;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.loadsir.callback.Callback;
import com.loadsir.core.LoadService;
import com.loadsir.core.LoadSir;
import com.willkong.loadsir.PostUtil;
import com.willkong.loadsir.callback.LottieEmptyCallback;
import com.willkong.loadsir.callback.LottieLoadingCallback;
import com.willkong.loadstate.R;


/**
 * Description:TODO
 * Create Time:2017/9/4 10:12
 */

public class LottieActivity extends AppCompatActivity {

    private LoadService loadService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        LoadSir loadSir = new LoadSir.Builder()
                .addCallback(new LottieLoadingCallback())
                .addCallback(new LottieEmptyCallback())
                .setDefaultCallback(LottieLoadingCallback.class)
                .build();
        loadService = loadSir.register(this, new Callback.OnReloadListener() {
            @Override
            public void onReload(View v) {
                loadService.showCallback(LottieLoadingCallback.class);
                PostUtil.postSuccessDelayed(loadService, 1500);
            }
        });
        PostUtil.postCallbackDelayed(loadService, LottieEmptyCallback.class);
    }

}
