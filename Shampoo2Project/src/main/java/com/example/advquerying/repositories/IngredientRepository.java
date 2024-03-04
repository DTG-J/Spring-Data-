package com.example.advquerying.repositories;

import com.example.advquerying.entities.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository <Ingredient, Long>{

    List<Ingredient> findByNameStartingWith(String name);

    List<Ingredient> findByNameInOrderByPrice(List<String> names);
@Modifying
@Transactional
    @Query("UPDATE Ingredient AS i SET i.name = concat(i.name, 'Updated')")
    void increasePriceBy10Percent();
}
