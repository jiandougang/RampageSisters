package com.jiandougang.rampagesisters.dezhoubank.foundation;

import android.text.TextUtils;

import java.io.Serializable;
import java.util.List;

/**
 * Created by mabeijianxi on 2015/12/31.
 * 基金产品bean
 */
public class FoundationBean implements Serializable {

    private String puttingTime;
    private String objectId;


    private String productName;


    private String insuranceScope;

    private String productCompany;
    private String paymentWay;
    private String minimumAmount;
    private String createdAt;
    private String updatedAt;
    private List<String> paymentPeriod;
    private List<String> insurancePeriod;


    private String characteristic;
    private String suitableCrowd;
    private String briefIntroduction;


    private String foundationCode;


    private String foundationType;


    /**
     * 申购状态
     */
    private String applyState;


    private String redeemState;


    /**
     * 每万分收益
     */
    private int accumulativeNetAssetValue;


    /**
     * 是否被选中
     */
    private boolean isSelected;


    /**
     * ACL : {"*":{"write":true,"read":true}}
     * thousandsOfIncome : 0
     */

    private int thousandsOfIncome;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String ProductName) {
        this.productName = ProductName;
    }

    public String getPuttingTime() {
        return puttingTime;
    }

    public void setPuttingTime(String puttingTime) {
        this.puttingTime = puttingTime;
    }

    public static String prefixPuttingTime(final String puttingTime) {
        if (!TextUtils.isEmpty(puttingTime))
            return "上架时间为：" + puttingTime;
        else return "";
    }

    public String getProductCompany() {
        return productCompany;
    }

    public void setProductCompany(String productCompany) {
        this.productCompany = productCompany;
    }

    public String getPaymentWay() {
        return paymentWay;
    }

    public void setPaymentWay(String paymentWay) {
        this.paymentWay = paymentWay;
    }

    public String getMinimumAmount() {
        return minimumAmount;
    }

    public void setMinimumAmount(String minimumAmount) {
        this.minimumAmount = minimumAmount;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<String> getPaymentPeriod() {
        return paymentPeriod;
    }

    public void setPaymentPeriod(List<String> paymentPeriod) {
        this.paymentPeriod = paymentPeriod;
    }

    public List<String> getInsurancePeriod() {
        return insurancePeriod;
    }

    public void setInsurancePeriod(List<String> insurancePeriod) {
        this.insurancePeriod = insurancePeriod;
    }

    public String getCharacteristic() {
        return characteristic;
    }

    public void setCharacteristic(String characteristic) {
        this.characteristic = characteristic;
    }

    public String getSuitableCrowd() {
        return suitableCrowd;
    }

    public void setSuitableCrowd(String suitableCrowd) {
        this.suitableCrowd = suitableCrowd;
    }

    public String getBriefIntroduction() {
        return briefIntroduction;
    }

    public void setBriefIntroduction(String briefIntroduction) {
        this.briefIntroduction = briefIntroduction;
    }

    public String getInsuranceScope() {
        return insuranceScope;
    }

    public void setInsuranceScope(String insuranceScope) {
        this.insuranceScope = insuranceScope;
    }

    public boolean getSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }


    public String getFoundationCode() {
        return foundationCode;
    }

    public void setFoundationCode(String foundationCode) {
        this.foundationCode = foundationCode;
    }

    public String getApplyState() {
        return applyState;
    }

    public void setApplyState(String applyState) {
        this.applyState = applyState;
    }

    public int getNetAssetValue() {
        return netAssetValue;
    }

    public void setNetAssetValue(int netAssetValue) {
        this.netAssetValue = netAssetValue;
    }

    public String getFoundationType() {
        return foundationType;
    }

    public void setFoundationType(String foundationType) {
        this.foundationType = foundationType;
    }

    private int netAssetValue;

    public String getRedeemState() {
        return redeemState;
    }

    public void setRedeemState(String redeemState) {
        this.redeemState = redeemState;
    }

    public int getAccumulativeNetAssetValue() {
        return accumulativeNetAssetValue;
    }

    public void setAccumulativeNetAssetValue(int accumulativeNetAssetValue) {
        this.accumulativeNetAssetValue = accumulativeNetAssetValue;
    }

    public int getThousandsOfIncome() {
        return thousandsOfIncome;
    }

    public void setThousandsOfIncome(int thousandsOfIncome) {
        this.thousandsOfIncome = thousandsOfIncome;
    }
}
