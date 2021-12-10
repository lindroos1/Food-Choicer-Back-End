package com.example.demo.Models.repository;

import com.example.demo.Models.entities.Food;
import com.example.demo.Models.entities.Ingredients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {
    Food findByfoodName(String name);

}
