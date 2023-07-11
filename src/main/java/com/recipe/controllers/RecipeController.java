package com.recipe.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.recipe.entities.Recipe;
import com.recipe.exception.RecipeNotException;
import com.recipe.repository.IRecipeRepository;
import com.recipe.services.IRecipeService;


@RestController
@RequestMapping("/recipes")
public class RecipeController 
{
	@Autowired(required=false)
	IRecipeRepository recipeRepo;
	
	@Autowired(required=false)
	IRecipeService recipeService;
	
	@GetMapping("/allRecipes")
	public ResponseEntity<?> getAllRecipes() throws RecipeNotException
	{
		if(!recipeRepo.findAll().isEmpty())
			return new ResponseEntity<>(recipeService.getAllRecipes(),HttpStatus.OK);
		else
			throw new RecipeNotException("No Recipe Found in the List");
	}
	
	@PostMapping("/saveRecipe")
	public ResponseEntity<?> createRecipe(@RequestBody Recipe recipe) throws RecipeNotException
	{
		Optional<Recipe> opt=recipeRepo.findByName(recipe.getName());
		if(opt.isPresent())
			throw new RecipeNotException("Recipe already found");
		else
		{
			recipeService.saveRecipe(recipe);
			return new ResponseEntity<>("Reciep added sucessfully",HttpStatus.CREATED);
		}
	}
	
	@PutMapping("/updateRecipe/{recipeId}")
	public ResponseEntity<?> updateRecipe(@RequestBody Recipe recipe) throws RecipeNotException
	{
		if(recipeRepo.existsById(recipe.getRecipeId()))
		{
			recipeService.updateRecipe(recipe);
			return new ResponseEntity<>("Recipe Id"+ recipe.getRecipeId()+" is updated Sucessfully",HttpStatus.ACCEPTED);
		}
		else
			throw new RecipeNotException("Recipe Id"+ recipe.getRecipeId()+ " is not found");
		
	}
	
	
	
	@DeleteMapping("/deleteMapping/{recipeId}")
	public ResponseEntity<String> deleteRecipe(@PathVariable("recipeId") int recipeId) throws RecipeNotException
	{
		Optional<Recipe> opt=recipeRepo.findById(recipeId);
		if(opt.isPresent())
		{
			recipeService.deleteRecipe(recipeId);
			return new ResponseEntity<>("Recipe id: "+ recipeId+" is deleted Sucessfully", HttpStatus.OK);
		}
		else
			throw new RecipeNotException("Recipe id : "+recipeId+ " is not found");
		
		
	}
	
	
	
	
	
	
	
	
}
