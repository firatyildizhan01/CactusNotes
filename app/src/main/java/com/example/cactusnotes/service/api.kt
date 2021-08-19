package com.example.cactusnotes.service

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level.BODY
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


private val loggingInterceptor = HttpLoggingInterceptor().apply {
    setLevel(BODY)
}

private val client = OkHttpClient.Builder()
    .addInterceptor(loggingInterceptor)
    .build()

val api: NotesApi by lazy {
    Retrofit.Builder()
        .baseUrl("https://apps.cactus.school")
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(NotesApi::class.java)
}