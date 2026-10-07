package com.example.recipe.service;

import com.example.recipe.model.Recipe;
import com.example.recipe.model.RecipeStatus;
import com.example.recipe.repository.RecipeRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public Recipe createRecipe(Recipe recipe) {
        recipe.setId(null);
        recipe.setStatus(RecipeStatus.DRAFT);
        return recipeRepository.save(recipe);
    }

    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    public Recipe getRecipeById(Long id) {
        return recipeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Recipe not found with id " + id));
    }
}
