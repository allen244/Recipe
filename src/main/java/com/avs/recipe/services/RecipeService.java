package com.avs.recipe.services;

import com.avs.recipe.commands.RecipeCommand;
import com.avs.recipe.domain.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();

    Recipe findById(Long id);


    RecipeCommand saveRecipeCommand(RecipeCommand command);

    void deleteById(Long Id);

    RecipeCommand findCommandById(Long l);
}
