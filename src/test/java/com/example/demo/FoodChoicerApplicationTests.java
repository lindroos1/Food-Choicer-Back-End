package com.example.demo;

import com.example.demo.Models.entities.Food;
import com.example.demo.Models.entities.Ingredients;
import com.example.demo.Models.repository.IngredientsRepository;
import com.example.demo.Services.FoodService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class FoodChoicerApplicationTests {

	private final Food food = new Food();

	private final Ingredients ingredients = new Ingredients();

	@Autowired
	private  FoodService foodService;
	@Test
	void contextLoads() {
	}

	@Test
	void saveToDB(){
		food.setFoodName("пиле с ориз");
		ingredients.setIngredients("пиле, ориз, моркови");
		foodService.save(food, ingredients);
	}


}
