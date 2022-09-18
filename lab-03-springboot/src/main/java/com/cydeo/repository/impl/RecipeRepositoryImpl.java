package com.cydeo.repository.impl;

import com.cydeo.model.Recipe;
import com.cydeo.repository.RecipeRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RecipeRepositoryImpl implements RecipeRepository {
    List<Recipe> recipeList = new ArrayList<>();

    @Override
    public boolean save(Recipe recipe) {
        recipeList.add(recipe);
        return true;
    }
}
