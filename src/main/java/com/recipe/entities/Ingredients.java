package com.recipe.entities;

import jakarta.persistence.*;

@Entity
@Table(name="Ingredients")
public class Ingredients 
{
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id;
	
	@Column
	private String ingredientList;

	public int getIngredientId() {
		return id;
	}

	public void setIngredientId(int ingredientId) {
		this.id = ingredientId;
	}

	public String getIngredientList() {
		return ingredientList;
	}

	public void setIngredientList(String ingredientList) {
		this.ingredientList = ingredientList;
	}

	public Ingredients(int ingredientId, String ingredientList) {
		super();
		this.id = ingredientId;
		this.ingredientList = ingredientList;
	}
	
	public Ingredients()
	{
		super();
	}
}
