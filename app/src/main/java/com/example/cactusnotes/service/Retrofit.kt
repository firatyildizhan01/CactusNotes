package com.example.cactusnotes.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//QUESTIONS
//Q1 Why do we use file instead of class ?
// I dont understand why we use this phrase lazy
val api: SignupAPI by lazy {
    Retrofit.Builder()
        // builder and passing our base url
        .baseUrl("https://apps.cactus.school")
        // as we are sending data in json format so we have to add Gson converter factory
        .addConverterFactory(GsonConverterFactory.create())
        //we are building our retrofit builder
        .build()
        // Create Service
        .create(SignupAPI::class.java)
}