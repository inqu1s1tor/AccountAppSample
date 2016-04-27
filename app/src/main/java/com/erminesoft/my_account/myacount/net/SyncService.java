package com.erminesoft.my_account.myacount.net;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.util.Log;

import com.erminesoft.my_account.myacount.core.AAplication;
import com.erminesoft.my_account.myacount.core.bridge.DBbridge;
import com.erminesoft.my_account.myacount.core.bridge.NetBridge;
import com.erminesoft.my_account.myacount.model.Category;
import com.erminesoft.my_account.myacount.model.Cost;
import com.erminesoft.my_account.myacount.model.Income;
import com.erminesoft.my_account.myacount.util.ModelsMapper;

import java.util.Queue;

public final class SyncService extends IntentService {

    private final static String SERVICE_NAME = "synchronius";
    private boolean isWork;
    private DBbridge dbBridge;
    private NetBridge netBridge;

    private Queue<Category> categoriesCostQueue;
    private Queue<Category> categoriesIncomeQueue;
    private Queue<Cost> modelCostQueue;
    private Queue<Income> modelIncomeQueue;
    private Queue<Category> modelCategoryQueue;



    public SyncService() {
        super(SERVICE_NAME);
        isWork = false;
    }

    public static void start(Context context) {
        Intent intent = new Intent(context, SyncService.class);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {


        if (isWork) {
            Log.w(SERVICE_NAME, "Service already running");
            return;
        }

        isWork = true;
        initModules();
        repackModels();
        sendToServerCategory();
       /* sendToServerCostCategory();
        sendToServerIncomeCategory();*/
        sendToServerModelCost();
        sendToServerModelIncome();

    }

    private void initModules() {
        AAplication application = (AAplication) getApplicationContext();
        dbBridge = application.getDbManager();
        netBridge = application.getNetBridge();
    }


    private void repackModels(){
       /* Cursor cursorCostsCategories = dbBridge.loadCostsCategories();
        categoriesCostQueue = ModelsMapper.cursorToCategories(cursorCostsCategories);

        Cursor cursorIncomesCategories = dbBridge.loadIncomeCategories();
        categoriesIncomeQueue = ModelsMapper.cursorToCategories(cursorIncomesCategories);*/

        Cursor cursorCategories = dbBridge.getUnsentCategories();
        modelCategoryQueue = ModelsMapper.cursorToCategories(cursorCategories);

        Cursor modelCost = dbBridge.loadCosts();
        modelCostQueue = ModelsMapper.cursorToCosts(modelCost);

        Cursor modelIncome = dbBridge.loadIncome();
        modelIncomeQueue = ModelsMapper.cursorToIncomes(modelIncome);
    }

    private void sendToServerCategory(){
        Category category = modelCategoryQueue.poll();

        if (category == null) {
            return;
        }

        category = netBridge.addNewCategory(category);
        category.setSent(true);
        dbBridge.saveCategoryToDb(category);

        if(category != null) {
            sendToServerCategory();
        }

    }

    /*private void sendToServerCostCategory(){
        Category categoryCost = categoriesCostQueue.poll();

        if (categoryCost == null) {
            return;
        }

        categoryCost = netBridge.addNewCategory(categoryCost);

        if(categoryCost != null) {
            sendToServerCostCategory();
        }

    }

    private void sendToServerIncomeCategory(){
        Category categoryIncome = categoriesIncomeQueue.poll();

        if (categoryIncome == null) {
            return;
        }

        categoryIncome.setSent(true);

        categoryIncome = netBridge.addNewCategory(categoryIncome);
        if(categoryIncome != null) {
            sendToServerIncomeCategory();
        }

    }*/

    private void sendToServerModelCost(){
        Cost cost = modelCostQueue.poll();

        if (cost == null) {
            return;
        }

        cost.setSent(true);

        cost = netBridge.addNewCost(cost);
        if(cost != null) {
            sendToServerModelCost();
        }

    }

    private void sendToServerModelIncome(){
        Income income = modelIncomeQueue.poll();

        if (income == null) {
            return;
        }

        income.setSent(true);

        income = netBridge.addNewIncome(income);
        if(income != null) {
            sendToServerModelIncome();
        }

    }


}
