package com.jiandougang.rampagesisters.base.model.user;

import java.io.Serializable;
import java.util.List;

/**
 * 用户信息实体
 * Created by wuguohong on 16/9/6.
 */
public class RPUserBean implements Serializable {

    private String className;
    private Object updatedAt;
    private Object createdAt;
    private String objectId;
    private String mobilePhoneNumber;
    private String username;
    private String email;
    private String nickName;
    private boolean emailVerified;
    private boolean mobilePhoneVerified;


    private List<RPAddressBookBean> addressBook;

    private RPHeadPortraitBean headPortrait;

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

    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    public void setMobilePhoneNumber(String mobilePhoneNumber) {
        this.mobilePhoneNumber = mobilePhoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public boolean isEmailVerified() {
        return emailVerified;
    }

    public void setEmailVerified(boolean emailVerified) {
        this.emailVerified = emailVerified;
    }

    public boolean isMobilePhoneVerified() {
        return mobilePhoneVerified;
    }

    public void setMobilePhoneVerified(boolean mobilePhoneVerified) {
        this.mobilePhoneVerified = mobilePhoneVerified;
    }

    public List<RPAddressBookBean> getAddressBook() {
        return addressBook;
    }

    public void setAddressBook(List<RPAddressBookBean> addressBook) {
        this.addressBook = addressBook;
    }

    public RPHeadPortraitBean getHeadPortrait() {
//
//        AVObject user = AVObject.createWithoutData(LeanCloudObjectClass.RPFile, getHeadPortrait().getObjectId());
//        user.fetchInBackground("url", new GetCallback<AVObject>() {
//            @Override
//            public void done(AVObject avObject, AVException e) {
//
//                KLog.json(avObject.toJSONObject().toString());
//
//            }
//        });

//        Log.i("123aaa","getHeadPortrait:"+getHeadPortrait().getObjectId());
//        AVQuery<AVObject> query = new AVQuery<>(LeanCloudObjectClass.RPFile);
//        query.whereEqualTo("objectId", getHeadPortrait().getObjectId());
//        query.findInBackground(new FindCallback<AVObject>() {
//            @Override
//            public void done(List<AVObject> list, AVException e) {
//                List<AVObject> priorityEqualsZeroTodos = list;// 符合 priority = 0 的 Todo 数组
//                for (int i=0;i<priorityEqualsZeroTodos.size();i++){
//
//                    KLog.json(priorityEqualsZeroTodos.get(i).toJSONObject().toString());
//                }
//
//            }
//        });
        return headPortrait;
    }

    public void setHeadPortrait(RPHeadPortraitBean headPortrait) {
        this.headPortrait = headPortrait;
    }

}
