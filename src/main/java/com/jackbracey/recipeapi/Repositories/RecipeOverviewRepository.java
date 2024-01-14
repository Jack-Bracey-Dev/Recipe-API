package com.jackbracey.recipeapi.Repositories;

import com.jackbracey.recipeapi.Entities.RecipeOverviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeOverviewRepository extends JpaRepository<RecipeOverviewEntity, Integer> {
}
