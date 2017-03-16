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
    private String name, description;
    int preparationTime, cookingTime, numberOfPots;
    private RealmList<Ingredients> ingredients;
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

    public int getCookingTime() {
        return cookingTime;
    }

    public void setCookingTime(int cookingTime) {
        this.cookingTime = cookingTime;
    }

    public int getPreparationTime() {
        return preparationTime;
    }

    public void setPreparationTime(int preparationTime) {
        this.preparationTime = preparationTime;
    }

    public int getNumberOfPots() {
        return numberOfPots;
    }

    public void setNumberOfPots(int numberOfPots) {
        this.numberOfPots = numberOfPots;
    }

    public RealmList<Category> getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category.add(category);
    }






}


