package com.example.advquerying.services;

import com.example.advquerying.entities.Shampoo;
import com.example.advquerying.entities.Size;
import com.example.advquerying.repositories.ShampooRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ShampooServiceImpl implements ShampooService{
    private ShampooRepository shampooRepository;

    public ShampooServiceImpl(ShampooRepository shampooRepository) {
        this.shampooRepository = shampooRepository;
    }

    @Override
    public List<Shampoo> findByBrand(String brand) {
        return shampooRepository.findByBrand (brand);
    }

    @Override
    public List<Shampoo> findByBrandAndSize(String brand, Size size) {
        return shampooRepository.findByBrandAndSize(brand,size);
    }

    @Override
    public List<Shampoo> findBySizeOrderById(Size size) {
        return shampooRepository.findBySize (size);
    }

    @Override
    public List<Shampoo> findBySizeOrLabel(Size size, long labelId) {
        return shampooRepository.findBySizeOrLabelIdOrderByPrice(size, labelId);
    }

    @Override
    public List<Shampoo> findByPriceGreaterThan(BigDecimal price) {
        return shampooRepository.findByPriceGreaterThanOrderByPriceDesc(price);
    }

    @Override
    public int findCheaperThanCount(BigDecimal price) {
        return shampooRepository.countByPriceLessThan(price);
    }

    @Override
    public List<Shampoo> findAllWithIngredients(List<String> ingredientNames) {
        return shampooRepository.findByIngredientsNameIn(ingredientNames);
    }
}
