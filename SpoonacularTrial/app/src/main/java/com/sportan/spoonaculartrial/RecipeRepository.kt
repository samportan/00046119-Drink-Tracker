package com.sportan.spoonaculartrial

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RecipeRepository {
    private val apiService: ApiService = ApiClient.apiService

    fun getRandomRecipes(
        apiKey: String,
        number: Int,
        onResponse: (List<Recipe>?) -> Unit,
        onFailure: (Throwable) -> Unit
    ) {
        apiService.getRandomRecipes(apiKey, number).enqueue(object : Callback<ApiResponse> {
            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                if (response.isSuccessful) {
                    onResponse(response.body()?.recipes)
                } else {
                    onFailure(Throwable("Failed to fetch recipes"))
                }
            }

            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                onFailure(t)
            }
        })
    }
}