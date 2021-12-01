package com.example.demo.Services;

import com.example.demo.Models.entities.Ingredients;
import com.example.demo.Models.repository.IngredientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientsService {
    @Autowired
   private IngredientsRepository ingredientsRepository;

    public List<Ingredients> findAllbyIngredients(String ingr){
       return ingredientsRepository.findByingredientsContaining(ingr);
    }
}
