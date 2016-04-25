package com.erminesoft.my_account.myacount.model;

/**
 * Created by Aleks on 21.04.2016.
 */
public class Cost {
    private String ownerId;
    private int sumCostId;
    private String costName;
    private String costCategory;
    private boolean isSent;



    public int getSumCostId() {
        return sumCostId;
    }

    public void setSumCostId(int sumCostId) {
        this.sumCostId = sumCostId;
    }

    public String getCostName() {
        return costName;
    }

    public void setCostName(String costName) {
        this.costName = costName;
    }

    public String getCostCategory() {
        return costCategory;
    }

    public void setCostCategory(String costCategory) {
        this.costCategory = costCategory;
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
}
