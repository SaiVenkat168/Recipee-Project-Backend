package com.recipe.services;

import java.util.*;

import org.springframework.stereotype.Service;
import com.recipe.entities.*;

@Service
public interface IRecipeService
{
	public List<Recipe> getAllRecipes();
	
	public Recipe saveRecipe(Recipe recipe);
	
	public void updateRecipe(Recipe recipe);
	
	public void deleteRecipe(int recipeId);
	
	public Recipe getRecipe(int recipeId);
}
