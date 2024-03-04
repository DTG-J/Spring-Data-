package com.example.advquerying.services;

import com.example.advquerying.entities.Shampoo;
import com.example.advquerying.entities.Size;

import java.math.BigDecimal;
import java.util.List;

public interface ShampooService {


    List<Shampoo> findByBrand(String brand);
    List<Shampoo> findByBrandAndSize(String brand, Size size);

    List<Shampoo> findBySizeOrderById(Size size);

    List<Shampoo> findBySizeOrLabel(Size size, long labelId);

    List<Shampoo> findByPriceGreaterThan(BigDecimal price);


    int findCheaperThanCount(BigDecimal price);

    List<Shampoo> findAllWithIngredients(List<String> ingredientNames);
}
