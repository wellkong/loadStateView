package com.willkong.loadsir.target;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.loadsir.callback.Callback;
import com.loadsir.core.LoadService;
import com.loadsir.core.LoadSir;
import com.loadsir.core.Transport;
import com.willkong.loadsir.PostUtil;
import com.willkong.loadsir.callback.EmptyCallback;
import com.willkong.loadsir.callback.LoadingCallback;
import com.willkong.loadstate.R;


/**
 * Description:TODO
 * Create Time:2017/9/4 10:12
 */

public class NormalActivity extends AppCompatActivity {

    private LoadService loadService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        // Your can change the callback on sub thread directly.
        loadService = LoadSir.getDefault().register(this, new Callback.OnReloadListener() {
            @Override
            public void onReload(View v) {
                // Your can change the status out of Main thread.
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        loadService.showCallback(LoadingCallback.class);
                        //do retry logic...
                        SystemClock.sleep(500);
                        //callback
                        loadService.showSuccess();
                    }
                }).start();
            }
        }).setCallBack(EmptyCallback.class, new Transport() {
            @Override
            public void order(Context context, View view) {
                TextView mTvEmpty = (TextView) view.findViewById(R.id.tv_empty);
                mTvEmpty.setText("fine, no data. You must fill it!");
            }
        });
        PostUtil.postCallbackDelayed(loadService, EmptyCallback.class);
    }

}
