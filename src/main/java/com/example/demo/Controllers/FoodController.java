package com.example.demo.Controllers;

import com.example.demo.Models.entities.Food;
import com.example.demo.Services.FoodService;
import com.example.demo.Services.IngredientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class FoodController {
    @Autowired
    FoodService foodService;


    @Autowired
    IngredientsService ingredientsService;


    @GetMapping("getFood")
    public Food getFood(@RequestParam String foodName){
          return foodService.getFood(foodName);
    }


    @GetMapping("getFoodByIngredients")
    public Set<Food> getFoodByIngredients(@RequestParam List<String> ingr){
        return ingredientsService.findFoodsbyIngredients(ingr);
    }


    @GetMapping("getRandomFood")
    public Optional<Food> getRandomFood(){
        //get all
        var temp = foodService.getAll();
        //use random to get value between 0 and temp.length-1
        Random random = new Random();
        Long index = (long) random.nextInt(temp.size() - 1);
        return foodService.getFoodById(index);
    }

    @PostMapping("addFood")
    public void addFood(@RequestBody Food food){
         foodService.save(food);
    }

    @GetMapping("getAll")
    public List<Food> GetALL(){
       return foodService.getAll();
    }
}
