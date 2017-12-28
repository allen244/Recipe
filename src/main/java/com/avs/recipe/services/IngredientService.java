package com.avs.recipe.services;

import com.avs.recipe.commands.IngredientCommand;

public interface IngredientService {


    IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId);

    void deleteById(Long Id);

    IngredientCommand saveIngredientCommand(IngredientCommand command);
}
