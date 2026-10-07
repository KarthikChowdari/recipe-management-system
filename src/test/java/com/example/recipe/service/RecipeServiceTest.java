package com.example.recipe.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.recipe.model.Recipe;
import com.example.recipe.model.RecipeStatus;
import com.example.recipe.repository.RecipeRepository;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RecipeServiceTest {

    @Autowired
    private RecipeService recipeService;

    @Autowired
    private RecipeRepository recipeRepository;

    @BeforeEach
    void cleanUp() {
        recipeRepository.deleteAll();
    }

    private Recipe newValidRecipe() {
        Recipe recipe = new Recipe();
        recipe.setName("Pasta Aglio e Olio");
        recipe.setDescription("A quick garlic and olive oil pasta.");
        recipe.setIngredients("Spaghetti, garlic, olive oil, chilli flakes, parsley");
        recipe.setInstructions("Boil pasta. Fry garlic in oil. Toss and serve.");
        recipe.setCategory("Dinner");
        return recipe;
    }

    @Test
    void validRecipeIsSavedAndPersisted() {
        Recipe saved = recipeService.createRecipe(newValidRecipe());

        assertThat(saved.getId()).isNotNull();

        Optional<Recipe> found = recipeRepository.findById(saved.getId());
        assertThat(found).isPresent();

        Recipe persisted = found.get();
        assertThat(persisted.getName()).isEqualTo("Pasta Aglio e Olio");
        assertThat(persisted.getDescription()).isEqualTo("A quick garlic and olive oil pasta.");
        assertThat(persisted.getCategory()).isEqualTo("Dinner");
        assertThat(persisted.getCreatedAt()).isNotNull();
        assertThat(persisted.getUpdatedAt()).isNotNull();
    }

    @Test
    void newlyCreatedRecipeDefaultsToDraftStatus() {
        Recipe saved = recipeService.createRecipe(newValidRecipe());

        assertThat(saved.getStatus()).isEqualTo(RecipeStatus.DRAFT);

        Recipe persisted = recipeRepository.findById(saved.getId()).orElseThrow();
        assertThat(persisted.getStatus()).isEqualTo(RecipeStatus.DRAFT);
    }
}
