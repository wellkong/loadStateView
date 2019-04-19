package com.willkong.loadstate;

import android.app.Application;

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
    }
}
