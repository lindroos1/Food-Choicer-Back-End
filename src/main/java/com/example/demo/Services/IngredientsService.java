package com.example.demo.Services;

import com.example.demo.Models.entities.Food;
import com.example.demo.Models.entities.Ingredients;
import com.example.demo.Models.repository.IngredientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class IngredientsService {
    @Autowired
   private IngredientsRepository ingredientsRepository;


    /*
    you have ingredients and want to find all foods containing them
     */
    public Set<Food> findFoodsbyIngredients(List<String> ingr){
        Set<Food> food = new HashSet<>();
        for(var b:ingr){
            for(var a:ingredientsRepository.findByingredients(b)){
                food.add(a.getFood());
            }
        }
        return food;
    }
}
