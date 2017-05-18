package com.jiandougang.rampagesisters.main.activity;

import android.os.Bundle;

import com.jiandougang.rampagesisters.R;
import com.jiandougang.rampagesisters.base.RPBaseActivity;
import com.jiandougang.rampagesisters.main.fragment.RPEvaluationFragment;
import com.jiandougang.rampagesisters.main.view.bottombar.RPBottomBar;

/**
 * 主页activity
 * Created by wuguohong on 16/8/10.
 */
public class RPMainActivity extends RPBaseActivity {



    private RPBottomBar mRPBottomBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            loadRootFragment(R.id.fl_container, RPEvaluationFragment.newInstance());
        }


        initView();
        initEvent();
    }

    private void initView() {

        mRPBottomBar = (RPBottomBar) findViewById(R.id.bottomBar);


    }

    private void initEvent() {

        mRPBottomBar.setOnTabSelectedListener(new RPBottomBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position, int prePosition) {

            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {

            }
        });
    }
}
