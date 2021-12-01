package com.example.demo.Models.entities;


import javax.persistence.*;
@Entity
@Table(name="food")
public class Food {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name = "ingredients_id", referencedColumnName = "id")
    private Ingredients ingredients;

    @Column(name = "foodName")
    private String foodName;

    public Long getId() {
        return id;
    }

    public Ingredients getIngredients() {
        return ingredients;
    }

    public void setIngredients(Ingredients ingredients) {
        this.ingredients = ingredients;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

}
