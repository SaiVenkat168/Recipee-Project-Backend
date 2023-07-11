package com.recipe.servicesimplem;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recipe.entities.Recipe;
import com.recipe.repository.IRecipeRepository;
import com.recipe.services.IRecipeService;

@Service
public class RecipeServiceImplementation implements IRecipeService
{
	
	
	@Autowired
	IRecipeRepository recipeRepo;
	
	

	@Override
	public List<Recipe> getAllRecipes() {
		
		return recipeRepo.findAll();
	}

	@Override
	public Recipe saveRecipe(Recipe recipe) {
		return recipeRepo.save(recipe);
	}

	@Override
	public void updateRecipe(Recipe recipe) {
		recipeRepo.save(recipe);
		
	}

	@Override
	public void deleteRecipe(int recipeId) {
		recipeRepo.delete(getRecipe(recipeId));
		
	}

	@Override
	public Recipe getRecipe(int recipeId) {
		return recipeRepo.findById(recipeId).get();
	}

}
