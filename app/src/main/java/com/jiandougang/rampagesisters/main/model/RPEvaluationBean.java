package com.jiandougang.rampagesisters.main.model;

import com.jiandougang.rampagesisters.base.model.user.RPUserBean;

import java.io.Serializable;

/**
 * Created by mabeijianxi on 2015/12/31.
 * 评价详情
 */
public class RPEvaluationBean implements Serializable {

    /**
     * className : RPFriendCircle
     * talking : 朋友圈说说内容
     * updatedAt : 更新时间
     * createdAt : 创建时间
     * objectId : 对象id
     */

    private String className;
    private String talking;
    private String updatedAt;
    private String createdAt;
    private String objectId;
    private String picUrl;

    /**
     * className : _User
     * updatedAt : null
     * createdAt : null
     * objectId : 57c791f32e958a0068c3b649
     */

    private RPUserBean user;


    public RPEvaluationBean() {

    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getTalking() {
        return talking;
    }

    public void setTalking(String talking) {
        this.talking = talking;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public RPUserBean getUser() {
        return user;
    }

    public void setUser(RPUserBean user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "RPEvaluationBean {className=" + className + ", talking=" + talking + ", updatedAt=" + updatedAt + ", createdAt=" + createdAt + "}";
    }


}
