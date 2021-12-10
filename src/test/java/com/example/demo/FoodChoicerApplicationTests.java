package com.example.demo;

import com.example.demo.Models.entities.Food;
import com.example.demo.Models.entities.Ingredients;
import com.example.demo.Models.repository.FoodRepository;
import com.example.demo.Models.repository.IngredientsRepository;
import com.example.demo.Services.FoodService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
@Transactional
class FoodChoicerApplicationTests {

	private final Food food = new Food();

	private final Ingredients ingredients = new Ingredients();
	@Autowired
	private  IngredientsRepository ingredientsRepository;
	@Autowired
	private FoodRepository foodRepository;

	@Autowired
	private  FoodService foodService;
	@Test
	void contextLoads() {
	}

	@Test
	void saveToDB(){
		/*food.setFoodName("пиле с ориз");
		ingredients.setIngredients("пиле");
		food.setIngredients(ingredients);
		Ingredients in = new Ingredients();
		in.setIngredients("ориз");
		food.setIngredients(in);
		Ingredients inn = new Ingredients();
		inn.setIngredients("моркови");
		food.setIngredients(inn);
		foodService.save(food);*/
	}


	@Test
	void loadFromDBIngredients(){
		ingredients.setIngredients("пиле");
		//System.out.println(foodRepository.findAll().get(0).getIngredients().get(1).getIngredients());
		System.out.println(ingredientsRepository.findByingredients("пиле").get(0).getFood().getFoodName());
	}

	@Test
	void loadFood(){
		System.out.println(foodService.getFood("пиле с ориз").getFoodName());
	}
}
