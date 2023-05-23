package com.sportan.drinktracker.repositories

import com.sportan.drinktracker.data.model.DrinkModel

class DrinkRepository(private val drinks: MutableList<DrinkModel>) {

    fun getDrinks() = drinks

    fun addDrinks(drink: DrinkModel) = drinks.add(drink)

}