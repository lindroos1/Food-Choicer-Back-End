package com.example.demo.Models.entities;

import javax.persistence.*;

@Entity
@Table(name="ingredients")
public class Ingredients {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "ingredients")
    private  String ingredients;

    @OneToOne(mappedBy = "ingredients")
    private Food food;


    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
