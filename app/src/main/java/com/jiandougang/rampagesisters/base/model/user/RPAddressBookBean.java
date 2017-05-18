package com.jiandougang.rampagesisters.base.model.user;

/**
 * 通信录实体
 * Created by wuguohong on 16/9/7.
 */
public class RPAddressBookBean {

    private String className;
    private Object updatedAt;
    private Object createdAt;
    private String objectId;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Object getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Object updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Object getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Object createdAt) {
        this.createdAt = createdAt;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }
}
