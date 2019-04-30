package com.willkong.loadsir.target;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.loadsir.callback.Callback;
import com.loadsir.callback.HintCallback;
import com.loadsir.callback.ProgressCallback;
import com.loadsir.core.LoadService;
import com.loadsir.core.LoadSir;
import com.willkong.loadsir.PostUtil;
import com.willkong.loadstate.R;


/**
 * Description:TODO
 * Create Time:2017/9/4 10:12
 */

public class DefaultCallbackActivity extends AppCompatActivity {

    private LoadService loadService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        ProgressCallback loadingCallback = new ProgressCallback.Builder()
                .setTitle("Loading", R.style.Hint_Title)
//                .setAboveSuccess(true)// attach loadingView above successView
                .build();

        HintCallback hintCallback = new HintCallback.Builder()
                .setTitle("Error", R.style.Hint_Title)
                .setSubTitle("Sorry, buddy, I will try it again.")
                .setHintImg(R.drawable.error)
                .build();

        LoadSir loadSir = new LoadSir.Builder()
                .addCallback(loadingCallback)
                .addCallback(hintCallback)
                .setDefaultCallback(ProgressCallback.class)
                .build();

        loadService = loadSir.register(this, new Callback.OnReloadListener() {
            @Override
            public void onReload(View v) {
                loadService.showCallback(ProgressCallback.class);
                PostUtil.postSuccessDelayed(loadService);

            }
        });
        PostUtil.postCallbackDelayed(loadService, HintCallback.class);
    }

}
