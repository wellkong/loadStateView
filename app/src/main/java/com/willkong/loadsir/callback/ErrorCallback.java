package com.willkong.loadsir.callback;


import com.loadsir.callback.Callback;
import com.willkong.loadstate.R;

/**
 * Description:TODO
 * Create Time:2017/9/4 10:20
 */

public class ErrorCallback extends Callback {
    @Override
    protected int onCreateView() {
        return R.layout.layout_error;
    }
}
