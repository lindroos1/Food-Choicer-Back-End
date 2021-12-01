package com.example.demo.Models.repository;

import com.example.demo.Models.entities.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {
    Food findByfoodName(String name);
}
