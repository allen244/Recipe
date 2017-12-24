package com.avs.recipe.controllers;

import com.avs.recipe.domain.Category;
import com.avs.recipe.domain.UnitOfMeasure;
import com.avs.recipe.repositories.CategoryRepository;
import com.avs.recipe.repositories.RecipeRepository;
import com.avs.recipe.repositories.UnitOfMeasureRepository;
import com.avs.recipe.services.RecipeService;
import com.avs.recipe.services.RecipeServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Slf4j
@Controller
public class IndexController {

    private RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"", "/", "index"})
    public String getIndexPage(Model model) {
        System.out.println("building projectll----");

        model.addAttribute("recipes", recipeService.getRecipes());
        log.debug("loading index page");
        return "index";
    }
}
