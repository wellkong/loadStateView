package com.willkong.loadsir.callback;

import android.content.Context;
import android.view.View;

import com.loadsir.callback.Callback;
import com.willkong.loadstate.R;

/**
 * Description:TODO
 * Create Time:2017/9/4 10:22
 */

public class LoadingCallback extends Callback {

    @Override
    protected int onCreateView() {
        return R.layout.layout_loading;
    }

    @Override
    public boolean getSuccessVisible() {
        return super.getSuccessVisible();
    }

    @Override
    protected boolean onReloadEvent(Context context, View view) {
        return true;
    }
}
