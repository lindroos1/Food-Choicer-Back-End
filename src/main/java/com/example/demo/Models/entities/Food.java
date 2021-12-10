package com.example.demo.Models.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


/*
    Food has bidirectional relationship with Ingredients
 */
@Entity
@Table(name="food")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Food {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "food_id")
    @JsonManagedReference
    private  List<Ingredients> ingredients = new ArrayList<>();

    @Column(name = "foodName")
    private String foodName;
    public void setId(Long id) {this.id = id;}
    public Long getId() {
        return id;
    }

    public List<Ingredients> getIngredients() {
        return ingredients;
    }

    //public void setIngredients(Ingredients ingredient) {this.ingredients.add(ingredient);}

    public void setIngredients(List<Ingredients> ingredient) {
        this.ingredients = ingredient;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

}
