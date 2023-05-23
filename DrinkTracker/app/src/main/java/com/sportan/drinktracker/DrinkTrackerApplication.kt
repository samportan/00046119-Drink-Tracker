package com.sportan.drinktracker

import android.app.Application
import com.sportan.drinktracker.data.drinks
import com.sportan.drinktracker.repositories.DrinkRepository

class DrinkTrackerApplication(): Application() {

    val drinkRepository: DrinkRepository by lazy{
        DrinkRepository(drinks)
    }

}