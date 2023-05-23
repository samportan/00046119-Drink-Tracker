package com.sportan.drinktracker.ui.drink

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.sportan.drinktracker.DrinkTrackerApplication
import com.sportan.drinktracker.data.model.DrinkModel
import com.sportan.drinktracker.repositories.DrinkRepository

class DrinkViewModel(private val repository: DrinkRepository): ViewModel() {

    fun getDrinks() = repository.getDrinks()

    fun addDrinks(drink: DrinkModel) = repository.addDrinks(drink)

    companion object{
        val factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as DrinkTrackerApplication
                DrinkViewModel(app.drinkRepository)
            }
        }
    }

}