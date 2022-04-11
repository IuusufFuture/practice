package com.example.practice.dao;

import com.example.practice.model.Recipe;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Repository("recipeDao")
public class RecipeDao implements BaseDao<Recipe> {

    List<Recipe> recipeRepo = new ArrayList<>();

    @Override
    public Recipe save(Recipe type) {
        try {
            recipeRepo.add(type);
        } catch (Exception ex) {
            throw new RuntimeException("");
        }

        return type;
    }

    @Override
    public Recipe findById(UUID id) {
        return (Recipe) recipeRepo.stream()
                .filter(recipe -> recipe.getId().equals(id));
    }

    @Override
    public List<Recipe> findAll() {
        return recipeRepo;
    }

    @Override
    public Recipe deleteById(UUID id) {
        return (Recipe) recipeRepo.stream()
                .filter(recipe -> recipe.getId().equals(id))
                .map(recipe -> recipeRepo.remove(recipe));
    }

}
