package com.recipe.advice;

import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.*;
import java.time.LocalDateTime;

import com.recipe.*;
import com.recipe.exception.RecipeNotException;

@ControllerAdvice
public class ControllerExceptionHandiling 
{
	@ExceptionHandler(RecipeNotException.class)
	public ResponseEntity<?> recipeNotFoundExceptionMethod(RecipeNotException recipeNotFound){
		
		Map<String, Object> errorBody = new LinkedHashMap<>();
		
		errorBody.put("error", "Creation Failed");
		errorBody.put("timestamp", LocalDateTime.now());
		errorBody.put("details", recipeNotFound.getMessage());

		return new ResponseEntity<>(errorBody,HttpStatus.NOT_FOUND);
		
	}
}
