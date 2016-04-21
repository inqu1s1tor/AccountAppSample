package com.erminesoft.my_account.myacount.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Aleks on 21.04.2016.
 */
public class BackendlessUser implements Serializable {

    private String objectId;
    private List <Category> categoriesListModel;

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public List<Category> getCategoriesListModel() {
        return categoriesListModel;
    }

    public void setCategoriesListModel(List<Category> categoriesListModel) {
        this.categoriesListModel = categoriesListModel;
    }

    public List<Cost> getCostListModel() {
        return costListModel;
    }

    public void setCostListModel(List<Cost> costListModel) {
        this.costListModel = costListModel;
    }

    public List<Income> getIncomeListModel() {
        return incomeListModel;
    }

    public void setIncomeListModel(List<Income> incomeListModel) {
        this.incomeListModel = incomeListModel;
    }

    private List <Cost> costListModel;
    private List <Income> incomeListModel;

}
