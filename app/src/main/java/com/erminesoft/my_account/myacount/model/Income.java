package com.erminesoft.my_account.myacount.model;

/**
 * Created by Aleks on 21.04.2016.
 */
public class Income {
    private int incomeId;
    private int sumIncomeId;
    private String incomeName;
    private String incomeCategory;

    public int getIncomeId() {
        return incomeId;
    }

    public void setIncomeId(int incomeId) {
        this.incomeId = incomeId;
    }

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


}
