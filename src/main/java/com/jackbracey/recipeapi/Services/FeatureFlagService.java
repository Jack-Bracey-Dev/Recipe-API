package com.jackbracey.recipeapi.Services;

import com.jackbracey.recipeapi.Entities.FeatureFlagEntity;
import com.jackbracey.recipeapi.Repositories.FeatureFlagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class FeatureFlagService {

    private static final int CACHE_TIME = 1;

    private Map<FeatureFlagEntity, Timestamp> cache = new HashMap<>();

    @Autowired
    private FeatureFlagRepository featureFlagRepository;

    public FeatureFlagEntity save(FeatureFlagEntity entity) {
        this.removeFromCache(entity);
        return featureFlagRepository.save(entity);
    }

    public List<FeatureFlagEntity> saveAll(List<FeatureFlagEntity> entities) {
        return featureFlagRepository.saveAll(entities);
    }

    public Boolean getBoolean(String name) throws Exception {
        return Boolean.valueOf(getInternal(name).getValue());
    }

    public Integer getInteger(String name) throws Exception {
        return Integer.valueOf(getInternal(name).getValue());
    }

    public String getString(String name) throws Exception {
        return getInternal(name).getValue();
    }

    public Long getLong(String name) throws Exception {
        return Long.valueOf(getInternal(name).getValue());
    }

    private FeatureFlagEntity getInternal(String name) throws Exception {
        Optional<FeatureFlagEntity> entity = get(name);
        if (entity.isEmpty())
            throw new Exception(String.format("Feature flag '%s' does not exist", name));
        return entity.get();
    }

    private Optional<FeatureFlagEntity> get(String name) {
        Optional<FeatureFlagEntity> cachedValue = getFromCache(name);
        if (cachedValue.isPresent())
            return cachedValue;

        Optional<FeatureFlagEntity> entity = featureFlagRepository.findByNameIgnoreCase(name);
        entity.ifPresent(this::addToCache);

        return entity;
    }

    private Optional<FeatureFlagEntity> getFromCache(String name) {
        if (cache.size() < 1)
            return Optional.empty();

        List<Map.Entry<FeatureFlagEntity, Timestamp>> flags = cache.entrySet().stream()
                .filter(entry -> Objects.equals(entry.getKey().getName(), name))
                .toList();

        if (flags.size() < 1)
            return Optional.empty();

        Map.Entry<FeatureFlagEntity, Timestamp> cacheValue = flags.get(0);

        if (new Timestamp(cacheValue.getValue().getTime() + (1000L * 60 * 60 * CACHE_TIME))
                .before(new Timestamp(System.currentTimeMillis()))) {
            this.removeFromCache(cacheValue.getKey());
            return Optional.empty();
        }

        return Optional.of(cacheValue.getKey());
    }

    private void addToCache(FeatureFlagEntity entity) {
        cache.put(entity, new Timestamp(System.currentTimeMillis()));
    }

    private void removeFromCache(FeatureFlagEntity entity) {
        cache = cache.entrySet().stream()
                .filter(entry -> !entry.getKey().getName().equalsIgnoreCase(entity.getName()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (prev, next) -> next, HashMap::new));
    }

}
