package com.sportan.spoonaculartrial

data class ApiResponse(
    val recipes: List<Recipe>
)

data class Recipe(
    val id: Int,
    val title: String,
    val image: String,
    val extendedIngredients: List<Ingredient>,
    val summary: String,
    val instructions: String
    // Add other required properties
)

data class Ingredient(
    val name: String,
    val amount: Double,
    val unit: String
)