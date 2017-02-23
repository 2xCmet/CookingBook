package com.christian.cookingbook.baseClass;

import java.util.Locale;
import java.util.UUID;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Christian on 23.02.2017.
 */

public class Receipt extends RealmObject {

    @PrimaryKey
    private String id;
    private String name, description, cookingTime, preparationTime, numberOfPots;
    private RealmList<Ingredients> ingredients;
    private RealmList<Tag> tags;
    private RealmList<Category> category;

    public Receipt() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCookingTime() {
        return cookingTime;
    }

    public void setCookingTime(String cookingTime) {
        this.cookingTime = cookingTime;
    }

    public String getPreparationTime() {
        return preparationTime;
    }

    public void setPreparationTime(String preparationTime) {
        this.preparationTime = preparationTime;
    }

    public String getNumberOfPots() {
        return numberOfPots;
    }

    public void setNumberOfPots(String numberOfPots) {
        this.numberOfPots = numberOfPots;
    }





}


