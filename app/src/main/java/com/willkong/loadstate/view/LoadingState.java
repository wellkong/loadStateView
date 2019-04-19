package com.willkong.loadstate.view;

import com.willkong.loadstate.R;
import com.willkong.stateview.BaseStateControl;

/**
 * @author：willkong on 18/7/23 15:49
 */
public class LoadingState extends BaseStateControl {

    @Override
    protected int onCreateView() {
        return R.layout.loading_view;
    }


    @Override
    public boolean isVisible() {
        return super.isVisible();
    }

}
