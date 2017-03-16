package com.christian.cookingbook.database.interfaces;

import com.christian.cookingbook.baseClass.Category;
import com.christian.cookingbook.baseClass.Ingredients;
import com.christian.cookingbook.baseClass.Receipt;

import java.util.List;

import io.realm.RealmResults;

/**
 * Created by Christian on 24.02.2017.
 */

public interface ReceiptManager {

    List<Receipt> getReceipt(String name);
    List<Receipt> getReceipt(Category category);
    List<Receipt> getReceipt(List<Ingredients> ingredients);
    List<Receipt> getReceipt(Integer numberOfPots);
    List<Receipt> getReceipt(Integer preparationTime, Integer cookingTime);
    List<Receipt> getReceipts();
    RealmResults<Receipt> getRealmReceiptList();
    Receipt loadReceipt(String receiptId);
    Category getCategory(String categoryId);
    Category getCategoryByName(String name);
    List<Category> loadAllCategories();

    boolean deleteCategory(String categoryId);
    boolean deleteReceipt(String eventId);

    void writeReceipt(final Receipt receipt);
    void updateReceipt(final Receipt receipt, final String receiptId);

    void updateCategoryOfReceipt(final Receipt receipt, final Category category);
    void writeCategory(final Category category);

    void open();

    void close();

}
