package com.willkong.loadsir.target;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.loadsir.core.LoadService;
import com.loadsir.core.LoadSir;
import com.willkong.loadsir.PostUtil;
import com.willkong.loadsir.callback.CustomCallback;
import com.willkong.loadsir.callback.LoadingCallback;
import com.willkong.loadstate.R;

/**
 * Description:TODO
 * Create Time:2017/9/5 13:28
 */
public class NormalFragment extends Fragment {

    private LoadService loadService;
    private View rootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle
            savedInstanceState) {
        rootView = View.inflate(getActivity(), R.layout.fragment_a_content, null);
        LoadSir loadSir = new LoadSir.Builder()
                .addCallback(new CustomCallback())
                .addCallback(new LoadingCallback())
                .setDefaultCallback(LoadingCallback.class)
                .build();
        loadService = loadSir.register(rootView);
        return loadService.getLoadLayout();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        PostUtil.postCallbackDelayed(loadService, CustomCallback.class);
    }

}