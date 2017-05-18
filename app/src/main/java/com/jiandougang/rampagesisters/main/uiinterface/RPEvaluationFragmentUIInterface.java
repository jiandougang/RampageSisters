package com.jiandougang.rampagesisters.main.uiinterface;

import com.jiandougang.rampagesisters.main.model.RPEvaluationBean;

import java.util.ArrayList;

/**
 * RPEvaluationFragment UI更新接口
 * Created by wuguohong on 16/9/13.
 */
public interface RPEvaluationFragmentUIInterface {


    /**
     * 更新说说内容UI
     */
    void upDateRecycleView(ArrayList<RPEvaluationBean> list);
}
