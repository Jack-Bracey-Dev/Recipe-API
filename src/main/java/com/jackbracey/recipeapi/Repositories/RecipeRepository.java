package com.jackbracey.recipeapi.Repositories;

import com.jackbracey.recipeapi.Entities.RecipeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@SuppressWarnings("unused")
public interface RecipeRepository extends JpaRepository<RecipeEntity, Integer> {

    @Query("select r from recipe r where upper(r.name) like upper(concat('%', ?1, '%'))")
    List<RecipeEntity> findAllByName(String name);

}
