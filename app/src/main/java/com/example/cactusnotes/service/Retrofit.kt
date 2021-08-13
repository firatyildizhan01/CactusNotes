package com.example.cactusnotes.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val api: NotesApi by lazy {
    Retrofit.Builder()
        .baseUrl("https://apps.cactus.school")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(NotesApi::class.java)
}