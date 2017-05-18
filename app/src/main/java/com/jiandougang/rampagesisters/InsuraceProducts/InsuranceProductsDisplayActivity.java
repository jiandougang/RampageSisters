package com.jiandougang.rampagesisters.InsuraceProducts;

import android.os.Bundle;

import com.jiandougang.rampagesisters.InsuraceProducts.fragment.InsuranceProductsTitleFragment;
import com.jiandougang.rampagesisters.R;
import com.jiandougang.rampagesisters.base.RPBaseActivity;

/**
 * 保险产品展示
 * Created by wuguohong on 2017/5/17.
 */

public class InsuranceProductsDisplayActivity extends RPBaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insurance_products_list);


        if (savedInstanceState == null) {
            loadRootFragment(R.id.fl_products, InsuranceProductsTitleFragment.newInstance());
        }

    }

}
