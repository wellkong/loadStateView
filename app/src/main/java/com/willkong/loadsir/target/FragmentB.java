package com.willkong.loadsir.target;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.willkong.loadsir.PostUtil;
import com.willkong.loadsir.base.BaseFragment;
import com.willkong.loadsir.callback.EmptyCallback;
import com.willkong.loadsir.callback.LoadingCallback;
import com.willkong.loadstate.R;

import butterknife.BindView;

/**
 * Description:TODO
 * Create Time:2017/9/5 13:27
 */
public class FragmentB extends BaseFragment {
    @BindView(R.id.tv_result_b)
    TextView mTvResultB;

    @Override
    protected int onCreateFragmentView() {
        return R.layout.fragment_b_content;
    }

    @Override
    protected void loadNet() {
        // do net here...
        // call back
        PostUtil.postCallbackDelayed(mBaseLoadService, EmptyCallback.class);
    }

    @Override
    protected void onNetReload(View v) {
        mTvResultB.setText("Oh, Yes too.");
        Toast.makeText(getContext(), "reload in Fragment B", Toast.LENGTH_SHORT).show();
        mBaseLoadService.showCallback(LoadingCallback.class);
        //do retry logic...

        //callback
        PostUtil.postSuccessDelayed(mBaseLoadService);
    }
}