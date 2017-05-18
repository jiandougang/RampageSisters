package com.jiandougang.rampagesisters.InsuraceProducts;

import android.text.TextUtils;

import java.io.Serializable;
import java.util.List;

/**
 * Created by mabeijianxi on 2015/12/31.
 * 保险产品bean
 */
public class InsuranceBean implements Serializable {


    /**
     * puttingTime : 2015-12-08
     * objectId : 591c63aaa22b9d005843c198
     * createdAt : 2017-05-17T14:52:26.069Z
     * updatedAt : 2017-05-17T14:52:40.447Z
     * ACL : {"*":{"write":false,"read":true}}
     * productName : 安享年年
     */

    private String puttingTime;
    private String objectId;


    private String productName;
    /**
     * insuranceScope : 18岁--55岁
     * paymentPeriod : ["3年","5年","10年"]
     * ACL : {"*":{"write":false,"read":true}}
     * insurancePeriod : ["10年","20年"]
     * productCompany : 中国人民
     * paymentWay : 期缴
     * minimumAmount : 1000元起
     * createdAt : 2017-05-17T14:50:41.109Z
     * updatedAt : 2017-05-18T08:30:31.633Z
     */

    private String insuranceScope;
    /**
     * * : {"write":false,"read":true}
     */

    /**
     * paymentPeriod : ["3年","5年","10年"]
     * insurancePeriod : ["10年","20年"]
     * productCompany : 中国人民
     * paymentWay : 期缴
     * minimumAmount : 1000元起
     * createdAt : 2017-05-17T14:50:41.109Z
     * updatedAt : 2017-05-18T08:30:31.633Z
     */

    private String productCompany;
    private String paymentWay;
    private String minimumAmount;
    private String createdAt;
    private String updatedAt;
    private List<String> paymentPeriod;
    private List<String> insurancePeriod;

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
}
