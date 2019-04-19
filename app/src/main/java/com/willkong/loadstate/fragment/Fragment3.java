package com.willkong.loadstate.fragment;

import android.os.Bundle;
import android.os.Handler;

import com.willkong.loadstate.R;
import com.willkong.loadstate.view.ErrorState;
import com.willkong.loadstate.view.LoadingState;

/**
 * @author：willkong on 18/7/23 18:01
 */
public class Fragment3 extends BaseFragment {
    @Override
    protected void initView(Bundle savedInstanceState) {
        loadManager.showStateView(ErrorState.class, "3");


    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_3;
    }

    @Override
    protected void onStateRefresh() {
        loadManager.showStateView(LoadingState.class);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                loadManager.showSuccess();
            }
        }, 3000);
    }
}
