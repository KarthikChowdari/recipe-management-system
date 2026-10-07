package com.example.recipe.controller;

import com.example.recipe.model.Recipe;
import com.example.recipe.service.RecipeService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RecipeController {

    static final List<String> CATEGORIES =
            List.of("Breakfast", "Lunch", "Dinner", "Dessert", "Snack", "Beverage", "Other");

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/recipes";
    }

    @GetMapping("/recipes")
    public String listRecipes(Model model) {
        model.addAttribute("recipes", recipeService.getAllRecipes());
        return "recipes/list";
    }

    @GetMapping("/recipes/new")
    public String showCreateForm(Model model) {
        model.addAttribute("recipe", new Recipe());
        model.addAttribute("categories", CATEGORIES);
        return "recipes/form";
    }

    @PostMapping("/recipes")
    public String createRecipe(@Valid @ModelAttribute("recipe") Recipe recipe,
                               BindingResult bindingResult,
                               Model model,
                               RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("categories", CATEGORIES);
            return "recipes/form";
        }

        Recipe created = recipeService.createRecipe(recipe);
        redirectAttributes.addFlashAttribute("successMessage",
                "Recipe \"" + created.getName() + "\" created successfully with status DRAFT.");
        return "redirect:/recipes/" + created.getId();
    }

    @GetMapping("/recipes/{id}")
    public String viewRecipe(@PathVariable Long id, Model model) {
        model.addAttribute("recipe", recipeService.getRecipeById(id));
        return "recipes/detail";
    }
}
