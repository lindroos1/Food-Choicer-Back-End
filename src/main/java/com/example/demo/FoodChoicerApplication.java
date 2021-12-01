package com.example.demo;

import com.example.demo.Models.entities.Food;
import com.example.demo.Models.entities.Ingredients;
import com.example.demo.Models.repository.FoodRepository;
import com.example.demo.Services.FoodService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class FoodChoicerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodChoicerApplication.class, args);
	}

	

}
