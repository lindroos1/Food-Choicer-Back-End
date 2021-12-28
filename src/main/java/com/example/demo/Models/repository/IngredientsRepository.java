package com.example.demo.Models.repository;

import com.example.demo.Models.entities.Food;
import com.example.demo.Models.entities.Ingredients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientsRepository extends JpaRepository<Ingredients, Long> {
    List<Ingredients> findByingredientsContaining(String ingredients);
    List<Ingredients> findByingredients(String ingredients);
   // List<Ingredients> findByingredients(Ingredients ingredients);
}
