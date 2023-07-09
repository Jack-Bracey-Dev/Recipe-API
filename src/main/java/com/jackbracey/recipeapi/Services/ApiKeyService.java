package com.jackbracey.recipeapi.Services;

import com.jackbracey.recipeapi.Entities.ApiKeyEntity;
import com.jackbracey.recipeapi.Repositories.ApiKeyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ApiKeyService {

    @Autowired
    private ApiKeyRepository apiKeyRepository;

    public Optional<ApiKeyEntity> findByKey(UUID key) {
        return apiKeyRepository.findById(key);
    }

    public boolean exists(UUID key) {
        return apiKeyRepository.exists(Example.of(new ApiKeyEntity(key)));
    }

}
