package com.example.demo.Models.entities;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;

@Repository
public class FoodWithIngredientsPOJO {
    private String foodName;
    private String ingredientsName;

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getIngredientsName() {
        return ingredientsName;
    }

    public void setIngredientsName(String ingredientsName) {
        this.ingredientsName = ingredientsName;
    }

}
