package com.christian.cookingbook.database;

import android.content.Context;
import android.util.Log;

import com.christian.cookingbook.baseClass.Category;
import com.christian.cookingbook.baseClass.Ingredients;
import com.christian.cookingbook.baseClass.Receipt;
import com.christian.cookingbook.database.interfaces.ReceiptManager;
import java.util.List;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

/**
 * Created by Christian on 24.02.2017.
 */

public class ReceiptManagerRealm implements ReceiptManager{
    public final String DEBUG_TAG = getClass().getCanonicalName();
    private Realm realm;

    @Override
    public List<Receipt> getReceipt(String name) {
        Log.d("database", name);
        RealmResults<Receipt> result = realm.where(Receipt.class)
                                        .equalTo("name", name)
                                        .findAll();
        return result;
    }

    @Override
    public List<Receipt> getReceipt(Category category) {
        return null;
    }

    @Override
    public List<Receipt> getReceipt(List<Ingredients> ingredients) {
        return null;
    }

    @Override
    public List<Receipt> getReceipt(Integer numberOfPots) {
        return null;
    }

    @Override
    public List<Receipt> getReceipt(String preparationTime, String cookingTime) {
        return null;
    }

    @Override
    public List<Receipt> getReceipt() {
        return null;
    }

    @Override
    public List<Receipt> getRealmReceiptList() {
        return null;
    }

    @Override
    public Receipt loadReceipt(String receiptId) {
        return null;
    }

    @Override
    public Category getCategory(String categoryId) {
        return null;
    }

    @Override
    public Category getCategoryByName(String name) {
        return null;
    }

    @Override
    public List<Category> loadAllCategories() {
        return null;
    }

    @Override
    public boolean deleteCategory(String categoryId) {
        return false;
    }

    @Override
    public boolean deleteEvent(String eventId) {
        return false;
    }

    @Override
    public void writeReceipt(Receipt receipt) {

    }

    @Override
    public void updateReceipt(Receipt receipt) {

    }

    @Override
    public void updateCategoryOfReceipt(Receipt receipt, Category category) {

    }

    @Override
    public void writeCategory(Category category) {

    }

    public static void init(Context context) {
        Realm.init(context);
        RealmConfiguration config = new RealmConfiguration.Builder()
                                    .deleteRealmIfMigrationNeeded()
                                    .build();
        Realm.setDefaultConfiguration(config);
    }
    @Override
    public void open() {
        this.realm = Realm.getDefaultInstance();

    }

    @Override
    public void close() {
        realm.close();
        realm = null;
    }
}
