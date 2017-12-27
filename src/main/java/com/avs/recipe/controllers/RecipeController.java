package com.avs.recipe.controllers;

import com.avs.recipe.commands.RecipeCommand;
import com.avs.recipe.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RecipeController {

    RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping("/recipe/show/{id}")
    public String showById(@PathVariable String id, Model model) {

        model.addAttribute("recipe", recipeService.findById(new Long(id)));

        return "recipe/show";
    }

    @RequestMapping("recipe/new")
    public String newRecipe(Model model) {
        model.addAttribute("recipe", new RecipeCommand());

        return "recipe/createRecipe";

    }


    @PostMapping
    @RequestMapping("recipe")
    public String saveOrUpdateRecipe(@ModelAttribute RecipeCommand command) {
        RecipeCommand saveCommand = recipeService.saveRecipeCommand(command);
        return "redirect:/recipe/show/" + saveCommand.getId();
    }


}
