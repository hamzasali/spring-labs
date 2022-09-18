package com.cydeo.service.impl;

import com.cydeo.model.Recipe;
import com.cydeo.repository.RecipeRepository;
import com.cydeo.service.RecipeService;
import com.cydeo.service.ShareService;
import org.springframework.stereotype.Component;

@Component
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;
    private final ShareService shareService;

    public RecipeServiceImpl(RecipeRepository recipeRepository, ShareService shareService) {
        this.recipeRepository = recipeRepository;
        this.shareService = shareService;
    }

    @Override
    public boolean prepareRecipe() {
        Recipe recipe = new Recipe();

        return false;
    }
}
