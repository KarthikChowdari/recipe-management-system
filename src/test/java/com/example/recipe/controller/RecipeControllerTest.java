package com.example.recipe.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrlPattern;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import com.example.recipe.model.Recipe;
import com.example.recipe.model.RecipeStatus;
import com.example.recipe.repository.RecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class RecipeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private RecipeRepository recipeRepository;

    @BeforeEach
    void cleanUp() {
        recipeRepository.deleteAll();
    }

    @Test
    void createFormIsDisplayed() throws Exception {
        mockMvc.perform(get("/recipes/new"))
                .andExpect(status().isOk())
                .andExpect(view().name("recipes/form"))
                .andExpect(model().attributeExists("recipe"));
    }

    @Test
    void validRecipeFormIsSavedAndRedirectsToDetailPage() throws Exception {
        mockMvc.perform(post("/recipes")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("name", "Chocolate Chip Cookies")
                        .param("description", "Classic soft cookies.")
                        .param("ingredients", "Flour, butter, sugar, chocolate chips, eggs")
                        .param("instructions", "Mix ingredients. Bake at 180C for 12 minutes.")
                        .param("category", "Dessert"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrlPattern("/recipes/*"));

        assertThat(recipeRepository.count()).isEqualTo(1);
        Recipe saved = recipeRepository.findAll().get(0);
        assertThat(saved.getName()).isEqualTo("Chocolate Chip Cookies");
        assertThat(saved.getStatus()).isEqualTo(RecipeStatus.DRAFT);
    }

    @Test
    void missingRequiredFieldsShowValidationErrorsAndNothingIsSaved() throws Exception {
        mockMvc.perform(post("/recipes")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("name", "")
                        .param("description", "")
                        .param("ingredients", "")
                        .param("instructions", "")
                        .param("category", ""))
                .andExpect(status().isOk())
                .andExpect(view().name("recipes/form"))
                .andExpect(model().attributeHasFieldErrors(
                        "recipe", "name", "description", "ingredients", "instructions", "category"));

        assertThat(recipeRepository.count()).isZero();
    }
}
