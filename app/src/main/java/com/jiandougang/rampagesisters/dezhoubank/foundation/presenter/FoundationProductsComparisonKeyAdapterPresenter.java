package com.jiandougang.rampagesisters.dezhoubank.foundation.presenter;

import com.jiandougang.rampagesisters.dezhoubank.foundation.FoundationBean;

import java.util.ArrayList;
import java.util.List;

/**
 * FoundationProductsComparisonKeyAdapter逻辑执行类
 * Created by wuguohong on 2017/5/22.
 */

public class FoundationProductsComparisonKeyAdapterPresenter {

    /**
     * 数据转换
     *
     * @param dataList 原始数据
     * @return 经转换后的数据
     */
    public List<String> transformDataList(List<FoundationBean> dataList) {
        int size = dataList.size();

        List<String> realData = new ArrayList<>();
        for (int i = 0; i < size; i++) {//基金名称
            realData.add(dataList.get(i).getProductName());
        }

        for (int i = 0; i < size; i++) {//基金代码
            realData.add(dataList.get(i).getFoundationCode());
        }

        for (int i = 0; i < size; i++) {//基金类型
            realData.add(dataList.get(i).getFoundationType());
        }

        for (int i = 0; i < size; i++) {//申购状态
            realData.add(dataList.get(i).getApplyState());
        }

        for (int i = 0; i < size; i++) {//赎回状态
            realData.add(dataList.get(i).getRedeemState());
        }

        for (int i = 0; i < size; i++) {//单位净值
            realData.add(String.valueOf(dataList.get(i).getNetAssetValue()));
        }

        for (int i = 0; i < size; i++) {//累计净值
            realData.add(String.valueOf(dataList.get(i).getAccumulativeNetAssetValue()));
        }

        for (int i = 0; i < size; i++) {//每万分收益
            realData.add(String.valueOf(dataList.get(i).getThousandsOfIncome()));
        }

        return realData;
    }
}
