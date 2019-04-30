package com.willkong.loadsir;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.willkong.loadsir.target.AnimateActivity;
import com.willkong.loadsir.target.BestPracticesActivity;
import com.willkong.loadsir.target.ConvertorActivity;
import com.willkong.loadsir.target.DefaultCallbackActivity;
import com.willkong.loadsir.target.FragmentSingleActivity;
import com.willkong.loadsir.target.KeepTitleActivity;
import com.willkong.loadsir.target.KeepTitleFragmentActivity;
import com.willkong.loadsir.target.MultiFragmentActivity;
import com.willkong.loadsir.target.MultiFragmentWithViewPagerActivity;
import com.willkong.loadsir.target.NormalActivity;
import com.willkong.loadsir.target.PlaceholderActivity;
import com.willkong.loadsir.target.ViewTargetActivity;
import com.willkong.loadstate.R;

/**
 * Description:TODO
 * Create Time:2017/9/2 16:02
 */

public class MainLoadsirActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_loadsir);
    }

    public void inActivity(View view) {
        startActivity(new Intent(this, NormalActivity.class));
    }

    public void showPlaceholder(View view) {
        startActivity(new Intent(this, PlaceholderActivity.class));
    }

    public void inActivityWithConvertor(View view) {
        startActivity(new Intent(this, ConvertorActivity.class));
    }

    public void inFragment(View view) {
        startActivity(new Intent(this, FragmentSingleActivity.class));
    }

    public void inFragmentMutil(View view) {
        startActivity(new Intent(this, MultiFragmentActivity.class));
    }

    public void inFragmentViewSirPager(View view) {
        startActivity(new Intent(this, MultiFragmentWithViewPagerActivity.class));
    }

    public void inView(View view) {
        startActivity(new Intent(this, ViewTargetActivity.class));
    }

    public void defaultCallback(View view) {
        startActivity(new Intent(this, DefaultCallbackActivity.class));
    }

    public void animatCallback(View view) {
        startActivity(new Intent(this, AnimateActivity.class));
    }

    public void keepTitleInFragment(View view) {
        startActivity(new Intent(this, KeepTitleFragmentActivity.class));
    }

    public void bestPractices(View view) {
        startActivity(new Intent(this, BestPracticesActivity.class));
    }

    public void keepTitleInActivity(View view) {
        startActivity(new Intent(this, KeepTitleActivity.class));
    }
}
