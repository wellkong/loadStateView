package com.willkong.loadsir.callback;

import com.loadsir.callback.Callback;
import com.willkong.loadstate.R;

/**
 * Description:TODO
 * Create Time:2017/9/4 10:22
 */

public class EmptyCallback extends Callback {

    @Override
    protected int onCreateView() {
        return R.layout.layout_empty;
    }

}
