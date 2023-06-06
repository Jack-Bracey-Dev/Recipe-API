package com.jackbracey.recipeapi.Services;

import com.jackbracey.recipeapi.Entities.IngredientEntity;
import com.jackbracey.recipeapi.Repositories.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IngredientService {

    @Autowired
    private IngredientRepository ingredientRepository;

    public IngredientEntity save(IngredientEntity ingredient) {
        return ingredientRepository.save(ingredient);
    }

    public boolean exists(Integer id) {
        return ingredientRepository.existsById(id);
    }

    public Optional<IngredientEntity> findById(Integer id) {
        return ingredientRepository.findById(id);
    }

}
