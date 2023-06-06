package com.jackbracey.recipeapi.Services;

import com.jackbracey.recipeapi.Entities.IngredientEntity;
import com.jackbracey.recipeapi.Entities.RecipeEntity;
import com.jackbracey.recipeapi.Helpers.FilterHelper;
import com.jackbracey.recipeapi.Helpers.HibernateUtil;
import com.jackbracey.recipeapi.POJOs.RecipeFilter;
import com.jackbracey.recipeapi.Repositories.RecipeRepository;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@SuppressWarnings("unused")
public class RecipeService {

    @Autowired
    private HibernateUtil hibernateUtil;

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private IngredientService ingredientService;

    @Autowired
    private MeasurementService measurementService;

    public List<RecipeEntity> getAll() {
        return recipeRepository.findAll();
    }

    public RecipeEntity save(RecipeEntity recipeEntity) {
        List<IngredientEntity> ingredients = recipeEntity.getIngredients();
        recipeEntity.setIngredients(null);
        recipeEntity = recipeRepository.save(recipeEntity);

        List<IngredientEntity> storedIngredients = checkAndStoreIngredients(ingredients, recipeEntity);
        recipeEntity.setIngredients(storedIngredients);
        return recipeRepository.save(recipeEntity);
    }

    private List<IngredientEntity> checkAndStoreIngredients(List<IngredientEntity> ingredientEntities,
                                                            RecipeEntity recipeEntity) {
        if (ingredientEntities == null || ingredientEntities.size() == 0)
            return ingredientEntities;

        List<IngredientEntity> storedIngredientList = new ArrayList<>();
        for (IngredientEntity ingredient : ingredientEntities) {
            ingredient.setRecipe(recipeEntity);

            /* If the ingredient hasn't been stored, then store it... */
            if (ingredient.getId() == null) {
                storedIngredientList.add(ingredientService.save(ingredient));
                continue;
            }

            /* If the ingredient has an ID, but hasn't been stored
             * clear the id and store it */
            if (!ingredientService.exists(ingredient.getId())) {
                ingredient.setId(null);
                storedIngredientList.add(ingredientService.save(ingredient));
                continue;
            }

            /* If it does exist, check if there is changes and if so, re-store it with the new changes */
            Optional<IngredientEntity> storedIngredient = ingredientService.findById(ingredient.getId());
            if (storedIngredient.isEmpty() || !ingredient.equals(storedIngredient.get())) {
                storedIngredientList.add(ingredientService.save(ingredient));
                continue;
            }

            /* If it already exists, just add it to the new list */
            storedIngredientList.add(ingredient);
        }

        return storedIngredientList;
    }

    public boolean exists(RecipeEntity recipeEntity) {
        return this.exists(recipeEntity.getId());
    }

    public boolean exists(Integer recipeId) {
        return recipeRepository.existsById(recipeId);
    }

    public boolean remove(Integer id) {
        Optional<RecipeEntity> entity = recipeRepository.findById(id);
        if (entity.isEmpty())
            return false;
        recipeRepository.delete(entity.get());
        return !this.exists(id);
    }

    public List<RecipeEntity> findRecipesByFilter(RecipeFilter filter) {
        SessionFactory sessionFactory = hibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {

            HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<RecipeEntity> criteriaQuery = builder.createQuery(RecipeEntity.class);
            Root<RecipeEntity> root = criteriaQuery.from(RecipeEntity.class);
            criteriaQuery.select(root);

            applyFilters(filter, criteriaQuery, builder, root);

            Query<RecipeEntity> query = session.createQuery(criteriaQuery);
            query.setFirstResult(filter.getPaginationMin());
            query.setMaxResults(filter.getPaginationMax());
            return query.getResultList();
        }
    }

    private static void applyFilters(RecipeFilter filter, CriteriaQuery<RecipeEntity> criteriaQuery,
                                     HibernateCriteriaBuilder builder, Root<RecipeEntity> root) {
        List<Predicate> predicates = new ArrayList<>();

        FilterHelper.getEqualsFilter(filter.getId(), "id", builder, root, predicates);
        FilterHelper.getInFilter(filter.getIds(), "id", builder, root, predicates);

        FilterHelper.getLikeFilter(filter.getName(), "name", builder, root, predicates);
        FilterHelper.getLikeFilter(filter.getSource(), "source", builder, root, predicates);
        FilterHelper.getLikeFilter(filter.getUrl(), "url", builder, root, predicates);

        FilterHelper.getRangeFilter(filter.getPrepTimeMin(), filter.getPrepTimeMax(), "prepTime",
                builder, root, predicates);
        FilterHelper.getRangeFilter(filter.getCookTimeMin(), filter.getCookTimeMax(), "cookTime",
                builder, root, predicates);

        FilterHelper.getLikeFilter(filter.getDifficulty(), "difficulty", builder, root, predicates);

        FilterHelper.getRangeFilter(filter.getServesMin(), filter.getServesMax(), "serves",
                builder, root, predicates);

        FilterHelper.getLikeFilter(filter.getDescription(), "description", builder, root, predicates);

        FilterHelper.getRangeFilter(filter.getCaloriesMin(), filter.getCaloriesMax(), "calories",
                builder, root, predicates);
        FilterHelper.getRangeFilter(filter.getFatMin(), filter.getFatMax(), "fat",
                builder, root, predicates);
        FilterHelper.getRangeFilter(filter.getSaturatesMin(), filter.getSaturatesMax(), "saturates",
                builder, root, predicates);
        FilterHelper.getRangeFilter(filter.getSugarsMin(), filter.getSugarsMax(), "sugars",
                builder, root, predicates);
        FilterHelper.getRangeFilter(filter.getFibreMin(), filter.getFibreMax(), "fibre",
                builder, root, predicates);
        FilterHelper.getRangeFilter(filter.getProteinMin(), filter.getProteinMax(), "protein",
                builder, root, predicates);
        FilterHelper.getRangeFilter(filter.getSaltMin(), filter.getSaltMax(), "salt",
                builder, root, predicates);

        criteriaQuery.where(predicates.toArray(new Predicate[]{}));
    }

    private String getQueryStringFromFilter(RecipeFilter filter) {
        return "from RecipeEntity";
    }

}
