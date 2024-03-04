package com.example.advquerying;

import com.example.advquerying.entities.Ingredient;
import com.example.advquerying.entities.Shampoo;
import com.example.advquerying.entities.Size;
import com.example.advquerying.services.IngredientService;
import com.example.advquerying.services.ShampooService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.math.BigDecimal;
import java.util.List;

@Component
public class Runner implements CommandLineRunner {

    private ShampooService shampooService;
    private IngredientService ingredientService;


    public Runner(ShampooService shampooService, IngredientService ingredientService) {
        this.shampooService = shampooService;
        this.ingredientService = ingredientService;
    }

    @Override
    public void run(String... args) throws Exception {
        //Task0
       /* List<Shampoo> byBrand = shampooService.findByBrand("Swiss Green Apple & Nettle");
        List<Shampoo> byBrandAndSize = shampooService.findByBrandAndSize("Swiss Green Apple & Nettle", Size.SMALL);
        byBrandAndSize.forEach(System.out::println);
*/
        //Task1
       // List<Shampoo> bySize = shampooService.findBySizeOrderById(Size.MEDIUM);
        //Сортиране на данните от заявката от Java, но по-добре това да стане със SQL заявката!!!
        //bySize.sort((l,r) -> l.getId().compareTo(r.getId()));

        //Task2
       // List<Shampoo>result = shampooService.findBySizeOrLabel(Size.MEDIUM, 10L);

        //Task 3
        //List<Shampoo>result = shampooService.findByPriceGreaterThan(BigDecimal.valueOf(5));

        //Task4
        //List<Ingredient> result = ingredientService.findByName("M");

        //Task5
        //List<Ingredient> result = ingredientService.findByNameWithin(List.of("Lavender", "Herbs", "Apple"));

        //Task6
      //int count = shampooService.findCheaperThanCount(BigDecimal.valueOf(8.50));

        //Task7
       // List<Shampoo>result = shampooService.findAllWithIngredients(List.of("Berry", "Mineral-Collagen"));

       // System.out.println(result);

       //result.forEach(System.out::println);

      // ingredientService.increasePrice();// The method was changed to update Name

        ingredientService.deleteByName("AppleUpdated");












    }
}

