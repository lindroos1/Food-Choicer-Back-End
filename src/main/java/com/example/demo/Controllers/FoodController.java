package com.example.demo.Controllers;

import com.example.demo.Models.entities.Food;
import com.example.demo.Services.FoodService;
import com.example.demo.Services.IngredientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class FoodController {
    @Autowired
    FoodService foodService;


    @Autowired
    IngredientsService ingredientsService;


    @GetMapping("getFood")
    public Food getFood(@RequestParam String foodName){
          return foodService.getFood(foodName);
    }


    /*
        returns all foods containing any single value
     */
    @PostMapping("getFoodByIngredients")
    public Set<Food> getFoodByIngredients(@RequestBody List<String> ingr){
        return ingredientsService.findFoodsbyIngredients(ingr);
    }


    @GetMapping("getRandomFood")
    public Food getRandomFood(){
        //get all
        var temp = foodService.getAll();
        //use random to get value between 0 and temp.length-1
        if(temp.size() > 0) {
            Random random = new Random();
            int index =  random.nextInt(temp.size());
            return temp.get(index);
        }
        return null;
    }

    @PostMapping("addFood")
    public void addFood(@RequestBody Food food){
       if(food.getFoodName().length() > 0 && food.getIngredients().size() > 0){
           foodService.save(food);
       }
    }

    @GetMapping("getAll")
    public List<Food> GetALL(){
       return foodService.getAll();
    }
}
