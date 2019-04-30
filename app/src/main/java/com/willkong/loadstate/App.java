package com.willkong.loadstate;

import android.app.Application;

import com.loadsir.core.LoadSir;
import com.willkong.loadsir.callback.CustomCallback;
import com.willkong.loadsir.callback.EmptyCallback;
import com.willkong.loadsir.callback.ErrorCallback;
import com.willkong.loadsir.callback.LoadingCallback;
import com.willkong.loadsir.callback.TimeoutCallback;
import com.willkong.loadstate.view.ErrorState;
import com.willkong.loadstate.view.LoadingState;
import com.willkong.stateview.core.LoadState;

/**
 * @author：willkong on 18/7/23 15:38
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        new LoadState.Builder()
                .register(new ErrorState())
                .register(new LoadingState())
                .setDefaultStateView(LoadingState.class)
                .build();
        LoadSir.beginBuilder()
                .addCallback(new ErrorCallback())
                .addCallback(new EmptyCallback())
                .addCallback(new LoadingCallback())
                .addCallback(new TimeoutCallback())
                .addCallback(new CustomCallback())
                .setDefaultCallback(LoadingCallback.class)
                .commit();
    }
}
