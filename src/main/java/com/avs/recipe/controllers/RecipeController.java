package com.avs.recipe.controllers;

import com.avs.recipe.commands.RecipeCommand;
import com.avs.recipe.exceptions.NotFoundException;
import com.avs.recipe.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class RecipeController {

    RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }


    @GetMapping("/recipe/{id}/show")
    public String showById(@PathVariable String id, Model model) {

        model.addAttribute("recipe", recipeService.findById(new Long(id)));

        return "recipe/show";
    }


    @GetMapping("recipe/new")
    public String newRecipe(Model model) {
        model.addAttribute("recipe", new RecipeCommand());

        return "recipe/createRecipe";

    }


    @GetMapping("/recipe/{id}/update")
    public String updateRecipe(@PathVariable String id, Model model) {
        model.addAttribute("recipe", recipeService.findCommandById(Long.valueOf(id)));
        return "recipe/createRecipe";
    }


    @GetMapping("/recipe/{id}/delete")
    public String deleteRecipe(@PathVariable String id) {

        log.debug("DELETEING ID" + id);
        recipeService.deleteById(Long.valueOf(id));
        return "redirect:/";
    }


    @PostMapping("recipe")
    public String saveOrUpdateRecipe(@ModelAttribute RecipeCommand command) {
        RecipeCommand saveCommand = recipeService.saveRecipeCommand(command);
        return "redirect:/recipe/" + saveCommand.getId() + "/show";
    }


}
