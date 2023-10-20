package com.jackbracey.recipeapi.Services;

import com.jackbracey.recipeapi.Entities.RecipeOverviewEntity;
import com.jackbracey.recipeapi.Repositories.RecipeOverviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Integer getLatestId() {
        Optional<RecipeOverviewEntity> optionalEntity = recipeOverviewRepository.findByIdOrderByIdDesc();
        return optionalEntity.map(RecipeOverviewEntity::getId).orElse(null);
    }

}