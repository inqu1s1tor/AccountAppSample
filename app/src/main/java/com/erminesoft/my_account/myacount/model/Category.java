package com.erminesoft.my_account.myacount.model;

import java.util.UUID;

/**
 * Created by Aleks on 21.04.2016.
 */
public class Category {
    private String categoryName;
    private int categoryType;
    private String uuid;
    private boolean isSent;
    private String objectId;


    public Category() {
        uuid = UUID.randomUUID().toString();
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(int categoryType) {
        this.categoryType = categoryType;
    }


    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public boolean isSent() {
        return isSent;
    }

    public void setSent(boolean sent) {
        isSent = sent;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }
}
