package com.willkong.loadsir.target;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.loadsir.callback.Callback;
import com.loadsir.core.LoadService;
import com.loadsir.core.LoadSir;
import com.willkong.loadsir.PostUtil;
import com.willkong.loadsir.callback.LoadingCallback;
import com.willkong.loadsir.callback.TimeoutCallback;
import com.willkong.loadstate.R;


/**
 * Description:TODO
 * Create Time:2017/9/3 11:22
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */

public class ViewTargetActivity extends AppCompatActivity {

    private LoadService loadService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        ImageView imageView = (ImageView) findViewById(R.id.iv_img);
        LoadSir loadSir = new LoadSir.Builder()
                .addCallback(new TimeoutCallback())
                .addCallback(new LoadingCallback())
                .setDefaultCallback(LoadingCallback.class)
                .build();
        loadService = loadSir.register(imageView, new Callback.OnReloadListener() {
            @Override
            public void onReload(View v) {
                loadService.showCallback(LoadingCallback.class);
                //do retry logic...

                //callback
                PostUtil.postSuccessDelayed(loadService);
            }
        });
        PostUtil.postCallbackDelayed(loadService, TimeoutCallback.class);
    }

}
