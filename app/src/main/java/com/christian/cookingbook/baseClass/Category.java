package com.christian.cookingbook.baseClass;

import java.util.UUID;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Christian on 23.02.2017.
 */

public class Category extends RealmObject {

    @PrimaryKey
    private String id;
    private String name;

    public Category() {
        if (this.id == null) {
            this.id = UUID.randomUUID().toString();
        }
    }

    public Category(String name) {
        if (this.id == null) {
            this.id = UUID.randomUUID().toString();
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
