package com.erminesoft.my_account.myacount.model;

import java.util.UUID;

/**
 * Created by Aleks on 21.04.2016.
 */
public class Category {
    private int categoryId;
    private String categoryName;
    private int categoryType;
    private String uuid;

    public Category() {
        uuid = UUID.randomUUID().toString();
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
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
}
