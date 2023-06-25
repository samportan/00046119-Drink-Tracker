package com.sportan.spoonaculartrial

import android.app.Application

class App : Application() {
    val viewModelFactory: ViewModelFactory by lazy {
        ViewModelFactory(this)
    }
}