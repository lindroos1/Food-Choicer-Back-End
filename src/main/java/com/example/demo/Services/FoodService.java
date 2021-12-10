package com.example.demo.Services;

import com.example.demo.Models.entities.Food;
import com.example.demo.Models.repository.FoodRepository;
import com.example.demo.Models.repository.IngredientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodService {
    @Autowired
    private FoodRepository foodRepository;
    @Autowired
    private IngredientsRepository ingredientsRepository;

    //get food && igredients from the controller
    //save them to the DB

    public void save(Food food){
        //if the food record doesn't exist
        if(foodRepository.findByfoodName(food.getFoodName()) == null){
            //save food in the food table
            foodRepository.save(food);
        }
    }
    public Food getFood(String foodName){
        return foodRepository.findByfoodName(foodName);
    }

    public List<Food> getAll(){
     return   foodRepository.findAll();
    }

    public Optional<Food> getFoodById(Long id){
       return foodRepository.findById(id);
    }

}
