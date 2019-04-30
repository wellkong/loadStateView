package com.willkong.loadsir.target;

import android.view.View;
import android.widget.TextView;

import com.willkong.loadsir.PostUtil;
import com.willkong.loadsir.base.BaseTitleActivity;
import com.willkong.loadsir.callback.ErrorCallback;
import com.willkong.loadsir.callback.LoadingCallback;
import com.willkong.loadstate.R;

import butterknife.BindView;

/**
 * Description:
 * Create Time:2017/9/4 10:56
 */

public class KeepTitleActivity extends BaseTitleActivity {
    @BindView(R.id.tv_title)
    TextView mTvTitle;


    @Override
    protected String getContentTitle() {
        return "Title";
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_content;
    }

    @Override
    protected void initView() {
        TextView mTvMsg = (TextView) findViewById(R.id.tv_subTitle);
        mTvMsg.setText("Keep Title In Activity");
        mTvTitle.setText("Yes, Success");
    }

    @Override
    protected void initNet() {
        PostUtil.postCallbackDelayed(mBaseLoadService, ErrorCallback.class);
    }

    @Override
    protected void onNetReload(View v) {
        mBaseLoadService.showCallback(LoadingCallback.class);
        PostUtil.postSuccessDelayed(mBaseLoadService);
    }
}
