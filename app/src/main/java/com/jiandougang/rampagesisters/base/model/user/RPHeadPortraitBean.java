package com.jiandougang.rampagesisters.base.model.user;

import com.jiandougang.rampagesisters.base.model.file.RPFile;

/**
 * user 头像
 * Created by wuguohong on 16/9/18.
 */
public class RPHeadPortraitBean {

    private String className;
    private Object updatedAt;
    private Object createdAt;
    private String objectId;
    private RPFile file;





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

    public RPFile getFile() {
        return file;
    }

    public void setFile(RPFile file) {
        this.file = file;
    }
}
