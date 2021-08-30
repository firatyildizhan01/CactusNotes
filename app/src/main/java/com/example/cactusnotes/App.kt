package com.example.cactusnotes

import android.app.Application
import com.example.cactusnotes.service.generateAuthenticationApi
import com.example.cactusnotes.service.generateNotesApi

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        generateAuthenticationApi()
        generateNotesApi(this)
    }
}

// 1. Custom Application class
// 2. Top-level declaration in Kotlin
// 3. How to prevent double initialization
// 4. How to expose a nullable variable as a none-nullable value
// 5. How to pass dependencies via constructor
// 6. How to create multiple api definitions and multiple retrofit objects