package com.jackbracey.recipeapi.Repositories;

import com.jackbracey.recipeapi.Entities.RecipeOverviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RecipeOverviewRepository extends JpaRepository<RecipeOverviewEntity, Integer> {
    @Query("select r from recipe_overview r order by r.id DESC limit 1")
    Optional<RecipeOverviewEntity> findByIdOrderByIdDesc();

}