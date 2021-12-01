package com.example.demo.Controllers;

import com.example.demo.Models.entities.Food;
import com.example.demo.Models.entities.FoodWithIngredientsPOJO;
import com.example.demo.Models.entities.Ingredients;
import com.example.demo.Services.FoodService;
import com.example.demo.Services.IngredientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class FoodController {
    @Autowired
    FoodService foodService;

    //if I dont create the food with "new" operator, and instead use Autowire
    //the JSON that is returned contains weird fields, and duplicates
    FoodWithIngredientsPOJO food  = new FoodWithIngredientsPOJO();

    @Autowired
    IngredientsService ingredientsService;


    @GetMapping("getFood")
    public FoodWithIngredientsPOJO getFood(@RequestParam String foodName){
      //find the food && ingredients
          food.setFoodName(foodService.getFood(foodName).getFoodName());
          food.setIngredientsName(foodService.getFood(foodName)
                  .getIngredients().getIngredients());
          return food;
      //return them
    }


    @GetMapping("getFoodByIngredients")
    public List<FoodWithIngredientsPOJO> getFoodByIngredients(@RequestParam String ingr){
        //find the food && ingredients
        List<FoodWithIngredientsPOJO> list = new ArrayList<FoodWithIngredientsPOJO>();

        for(var a:ingredientsService.findAllbyIngredients(ingr)){
            FoodWithIngredientsPOJO temp = new FoodWithIngredientsPOJO();
            temp.setFoodName(a.getFood().getFoodName());
            temp.setIngredientsName(a.getIngredients());
            if(!temp.getFoodName().isEmpty()) {
                list.add(temp);
            }
        }
        return list;
        //return them
    }


    @GetMapping("getRandomFood")
    public FoodWithIngredientsPOJO getRandomFood(){
        //get all
        var temp = foodService.getAll();
        //use random to get value between 0 and temp.length-1
        Random random = new Random();
        int index = random.nextInt(temp.size()-1);
        //return that index
        food.setFoodName(temp.get(index).getFoodName());
        food.setIngredientsName(temp.get(index).getIngredients().getIngredients());
        return food;
    }

    @PostMapping("addFood")
    public void addFood(@RequestParam String food, @RequestParam String ingre){
          Food foodLocal = new Food();
          Ingredients ingredients = new Ingredients();
         foodLocal.setFoodName(food);
         ingredients.setIngredients(ingre);
         foodService.save(foodLocal, ingredients);
    }
}
