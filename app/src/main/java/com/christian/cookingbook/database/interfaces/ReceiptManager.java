package com.christian.cookingbook.database.interfaces;

import com.christian.cookingbook.baseClass.Category;
import com.christian.cookingbook.baseClass.Ingredients;
import com.christian.cookingbook.baseClass.Receipt;

import java.util.List;

/**
 * Created by Christian on 24.02.2017.
 */

public interface ReceiptManager {

    List<Receipt> getReceipt(String name);
    List<Receipt> getReceipt(Category category);
    List<Receipt> getReceipt(List<Ingredients> ingredients);
    List<Receipt> getReceipt(Integer numberOfPots);
    List<Receipt> getReceipt(String preparationTime, String cookingTime);
    List<Receipt> getReceipt();
    List<Receipt> getRealmReceiptList();
    Receipt loadReceipt(String receiptId);
    Category getCategory(String categoryId);
    Category getCategoryByName(String name);
    List<Category> loadAllCategories();

    boolean deleteCategory(String categoryId);
    boolean deleteEvent(String eventId);

    void writeReceipt(Receipt receipt);
    void updateReceipt(Receipt receipt);

    void updateCategoryOfReceipt(Receipt receipt, Category category);
    void writeCategory(Category category);

    void open();

    void close();

}
