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
        sendToServerModelCost();
        sendToServerModelIncome();

    }

    private void initModules() {
        AAplication application = (AAplication) getApplicationContext();
        dbBridge = application.getDbManager();
        netBridge = application.getNetBridge();
    }


    private void repackModels(){
        Cursor cursorCategories = dbBridge.getUnsentCategories();
        modelCategoryQueue = ModelsMapper.cursorToCategories(cursorCategories);

        Cursor modelCost = dbBridge.getUnsentCosts();
        modelCostQueue = ModelsMapper.cursorToCosts(modelCost);

        Cursor modelIncome = dbBridge.getUnsentIncomes();
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


    private void sendToServerModelCost(){
        Cost cost = modelCostQueue.poll();

        if (cost == null) {
            return;
        }

        cost = netBridge.addNewCost(cost);
        cost.setSent(true);
        dbBridge.saveCostToDb(cost);

        if(cost != null) {
            sendToServerModelCost();
        }

    }

    private void sendToServerModelIncome(){
        Income income = modelIncomeQueue.poll();

        if (income == null) {
            return;
        }

        income = netBridge.addNewIncome(income);
        income.setSent(true);
        dbBridge.saveIncomeToDb(income);

        if(income != null) {
            sendToServerModelIncome();
        }

    }


}
