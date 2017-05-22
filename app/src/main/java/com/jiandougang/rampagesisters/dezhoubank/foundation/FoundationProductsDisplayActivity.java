package com.jiandougang.rampagesisters.dezhoubank.foundation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.jiandougang.rampagesisters.R;
import com.jiandougang.rampagesisters.base.RPBaseActivity;
import com.jiandougang.rampagesisters.dezhoubank.foundation.fragment.FoundationProductsTitleFragment;
import com.jiandougang.rampagesisters.dezhoubank.insuranceProducts.InsuranceProductsDisplayActivity;

import me.yokeyword.fragmentation.anim.DefaultHorizontalAnimator;
import me.yokeyword.fragmentation.anim.FragmentAnimator;

/**
 * 保险产品展示
 * Created by wuguohong on 2017/5/17.
 */

public class FoundationProductsDisplayActivity extends RPBaseActivity {

    private Button btExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insurance_products_list);

        if (savedInstanceState == null) {
            initView();
            initEvent();
            loadRootFragment(R.id.fl_products, FoundationProductsTitleFragment.newInstance());
        }

    }

    private void initView() {
        btExit = (Button) findViewById(R.id.bt_exit);

    }

    private void initEvent() {
        btExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FoundationProductsDisplayActivity.this, InsuranceProductsDisplayActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
            }
        });
    }

    @Override
    protected FragmentAnimator onCreateFragmentAnimator() {
        // 设置横向(和安卓4.x动画相同)
        return new DefaultHorizontalAnimator();

    }
}
