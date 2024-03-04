package com.example.advquerying.services;

import com.example.advquerying.entities.Ingredient;

import java.util.List;

public interface IngredientService {
    List<Ingredient>findByName(String name);

    List<Ingredient> findByNameWithin(List<String> names);
}
