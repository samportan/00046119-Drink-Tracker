package com.sportan.spoonaculartrial

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RecipeViewModel(application: Application) : AndroidViewModel(application) {
    private val recipeRepository: RecipeRepository = RecipeRepository()

    private val _randomRecipes = MutableLiveData<List<Recipe>>()
    val randomRecipes: LiveData<List<Recipe>> get() = _randomRecipes

    fun fetchRandomRecipes(apiKey: String, number: Int) {
        recipeRepository.getRandomRecipes(
            apiKey,
            number,
            { recipes ->
                _randomRecipes.value = recipes
            },
            { error ->
                // Handle error
            }
        )
    }
}
