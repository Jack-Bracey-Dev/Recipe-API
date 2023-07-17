package com.jackbracey.recipeapi.Services;

import com.jackbracey.recipeapi.Entities.RecipeOverviewEntity;
import com.jackbracey.recipeapi.Repositories.RecipeOverviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeOverviewService {

    @Autowired
    private RecipeOverviewRepository recipeOverviewRepository;

    public RecipeOverviewEntity save(RecipeOverviewEntity entity) {
        return recipeOverviewRepository.save(entity);
    }

    public List<RecipeOverviewEntity> saveAll(List<RecipeOverviewEntity> entities) {
        return recipeOverviewRepository.saveAll(entities);
    }

    public List<RecipeOverviewEntity> getAll() {
        return recipeOverviewRepository.findAll();
    }

}
