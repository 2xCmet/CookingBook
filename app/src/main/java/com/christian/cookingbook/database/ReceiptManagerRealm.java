package com.christian.cookingbook.database;

import android.content.Context;
import android.util.Log;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmQuery;
import io.realm.RealmResults;
import io.realm.Sort;

import com.christian.cookingbook.baseClass.Category;
import com.christian.cookingbook.baseClass.Ingredients;
import com.christian.cookingbook.baseClass.Receipt;
import com.christian.cookingbook.database.interfaces.ReceiptManager;


/**
 * Created by Christian on 24.02.2017.
 */

public class ReceiptManagerRealm implements ReceiptManager {
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
        Log.d("database", category.toString());
        RealmResults<Receipt> result = realm.where(Receipt.class)
                .equalTo("category", category.toString())
                .findAll();
        return result;
    }

    @Override
    public List<Receipt> getReceipt(List<Ingredients> ingredients) {
        String[] ingredientsArray = new String[ingredients.size()];
        Log.d("database", ingredientsArray.toString());
        return realm.where(Receipt.class)
                .in("ingredients", ingredients.toArray(ingredientsArray))
                .findAll();
    }

    @Override
    public List<Receipt> getReceipt(Integer numberOfPots) {
        return realm.where(Receipt.class)
                .equalTo("numberOfPots", numberOfPots)
                .findAll();
    }

    @Override
    public List<Receipt> getReceipt(Integer preparationTime, Integer cookingTime) {
        return realm.where(Receipt.class)
                .lessThanOrEqualTo("preparationTime", preparationTime)
                .lessThanOrEqualTo("cookingTime", cookingTime)
                .findAll();
    }

    @Override
    public List<Receipt> getReceipts() {
        RealmQuery<Receipt> query = realm.where(Receipt.class);
        return query.findAll().sort("name");
    }

    @Override
    public RealmResults<Receipt> getRealmReceiptList() {
        RealmQuery<Receipt> query = realm.where(Receipt.class);
        return query.findAll().sort("name");
    }

    @Override
    public Receipt loadReceipt(String receiptId) {
        RealmQuery<Receipt> query = realm.where(Receipt.class);
        query.equalTo("id", receiptId);
        return query.findFirst();
    }

    @Override
    public Category getCategory(String categoryId) {
        RealmQuery<Category> query = realm.where(Category.class);
        query.equalTo("id", categoryId);
        return query.findFirst();
    }

    @Override
    public Category getCategoryByName(String name) {
        RealmQuery<Category> query = realm.where(Category.class);
        query.equalTo("name", name);
        return query.findFirst();
    }

    @Override
    public List<Category> loadAllCategories() {
        List<Category> categories;
        RealmQuery<Category> query = realm.where(Category.class);
        categories = query.findAllSorted("name", Sort.ASCENDING);
        return categories;
    }

    @Override
    public boolean deleteCategory(String categoryId) {
        RealmQuery<Category> query = realm.where(Category.class);
        query.equalTo("id", categoryId);
        final Category result = query.findFirst();
        if (result == null) {
            return false;
        } else {
            try {
                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        result.deleteFromRealm();
                    }
                });
                return true;
            } finally {
                return false;
            }
        }
    }

    @Override
    public boolean deleteReceipt(String receiptId) {
        RealmQuery<Category> query = realm.where(Category.class);
        query.equalTo("id", receiptId);
        final Category result = query.findFirst();
        if (result == null) {
            return false;
        } else {
            try {
                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        result.deleteFromRealm();
                    }
                });
                return true;
            } finally {
                return false;
            }
        }

    }

    @Override
    public void writeReceipt(final Receipt receipt) {
        try{
            realm.executeTransaction(new Realm.Transaction(){
                @Override
                public void execute(Realm realm){
                    realm.copyToRealmOrUpdate(receipt);
                }
            });
        }finally {
            Log.d("Receipt", receipt.toString());
        }
    }

    @Override
    public void updateReceipt(final Receipt receipt, final String receiptId) {
        try{
            realm.executeTransaction(new Realm.Transaction(){
                @Override
                public void execute(Realm realm){
                    receipt.setId(receiptId);
                    realm.copyToRealmOrUpdate(receipt);
                }
            });
        }finally {
            Log.d("Receipt", receipt.toString());
        }

    }

    @Override
    public void updateCategoryOfReceipt(final Receipt receipt, final Category category) {
        try{
            realm.executeTransaction(new Realm.Transaction(){
                @Override
                public void execute(Realm realm){
                    receipt.setCategory(category);
                    realm.copyToRealmOrUpdate(receipt);
                }
            });
        }finally {
            Log.d("Receipt", receipt.toString());
        }
    }

    @Override
    public void writeCategory(final Category category) {
        try{
            realm.executeTransaction(new Realm.Transaction(){
                @Override
                public void execute(Realm realm){
                    realm.copyToRealmOrUpdate(category);
                }
            });
        }finally {
            Log.d("Receipt", category.toString());
        }
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
