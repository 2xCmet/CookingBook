package com.christian.cookingbook;

import android.app.Application;

import com.christian.cookingbook.database.ReceiptManagerRealm;
import com.christian.cookingbook.database.interfaces.ReceiptManager;

/**
 * Created by Christian on 24.02.2017.
 */

public class Cookingbook extends Application {
    private static final String DEBUG_TAG = Cookingbook.class.getCanonicalName();
    private ReceiptManager receiptManager = new ReceiptManagerRealm();

    @Override
    public void onCreate(){
        super.onCreate();
        ReceiptManagerRealm.init(this);
    }
}
