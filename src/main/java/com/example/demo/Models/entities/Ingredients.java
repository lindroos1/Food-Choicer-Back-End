package com.example.demo.Models.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name="ingredients")
public class Ingredients {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "ingredients")
    private  String ingredients ;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private Food food;



    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }
    public void setFood(Food food) {this.food = food;}
    public void setId(Long id) {
        this.id = id;
    }


    public String getIngredients() {
        return ingredients;
    }
    public Food getFood() {
        return food;
    }
    public Long getId() {
        return id;
    }

}
