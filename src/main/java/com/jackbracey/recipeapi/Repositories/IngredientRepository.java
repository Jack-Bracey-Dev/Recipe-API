package com.jackbracey.recipeapi.Repositories;

import com.jackbracey.recipeapi.Entities.IngredientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends JpaRepository<IngredientEntity, Integer> {
}
