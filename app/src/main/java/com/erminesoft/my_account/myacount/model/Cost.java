package com.erminesoft.my_account.myacount.model;

/**
 * Created by Aleks on 21.04.2016.
 */
public class Cost {
    private int costId;
    private int sumCostId;
    private String costName;
    private String costCategory;

    public int getCostId() {
        return costId;
    }

    public void setCostId(int costId) {
        this.costId = costId;
    }

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
}
