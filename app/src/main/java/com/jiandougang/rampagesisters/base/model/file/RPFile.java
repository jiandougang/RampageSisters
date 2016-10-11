package com.jiandougang.rampagesisters.base.model.file;

import com.jiandougang.rampagesisters.base.model.RPACLBean;

/**
 * Created by wuguohong on 16/9/18.
 */
public class RPFile {

    private String key;

    private RPACLBean ACL;

    private String name;
    private String url;

    private MetaDataBean metaData;
    private String bucket;
    private String objectId;
    private String createdAt;
    private String updatedAt;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public MetaDataBean getMetaData() {
        return metaData;
    }

    public void setMetaData(MetaDataBean metaData) {
        this.metaData = metaData;
    }

    public String getBucket() {
        return bucket;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
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

    public static class MetaDataBean {
        private String owner;
        private int size;

        public String getOwner() {
            return owner;
        }

        public void setOwner(String owner) {
            this.owner = owner;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }
    }
}
