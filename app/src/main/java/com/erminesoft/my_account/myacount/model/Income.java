package com.erminesoft.my_account.myacount.model;

/**
 * Created by Aleks on 21.04.2016.
 */
public class Income {
    private String ownerId;
    private int sumIncomeId;
    private String incomeName;
    private String incomeCategory;
    private boolean isSent;
    private String uuid;


    public int getSumIncomeId() {
        return sumIncomeId;
    }

    public void setSumIncomeId(int sumIncomeId) {
        this.sumIncomeId = sumIncomeId;
    }

    public String getIncomeName() {
        return incomeName;
    }

    public void setIncomeName(String incomeName) {
        this.incomeName = incomeName;
    }

    public String getIncomeCategory() {
        return incomeCategory;
    }

    public void setIncomeCategory(String incomeCategory) {
        this.incomeCategory = incomeCategory;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public boolean isSent() {
        return isSent;
    }

    public void setSent(boolean sent) {
        isSent = sent;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
