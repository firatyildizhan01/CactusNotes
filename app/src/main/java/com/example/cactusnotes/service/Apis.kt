@file:JvmName("AuthenticationApiKt")

package com.example.cactusnotes.service

import android.content.Context
import com.example.cactusnotes.userstore.UserStore
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level.BODY
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


private var _notesApi: NotesApi? = null
val notesApi get() = _notesApi!!

fun generateNotesApi(context: Context) {
    if (_notesApi != null) return

    val loggingInterceptor = HttpLoggingInterceptor().apply {
        setLevel(BODY)
    }

    val userStore = UserStore(context)

    val authInterceptor = AuthInterceptor(userStore)

    val notesApiClient = OkHttpClient.Builder()
        .addInterceptor(authInterceptor)
        .addInterceptor(loggingInterceptor)
        .build()

    _notesApi = Retrofit.Builder()
        .baseUrl("https://apps.cactus.school")
        .client(notesApiClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(NotesApi::class.java)
}

private var _authenticationApi: AuthenticationApi? = null
val authenticationApi get() = _authenticationApi!!

fun generateAuthenticationApi() {
    val loggingInterceptor = HttpLoggingInterceptor().apply {
        setLevel(BODY)
    }


    val authenticationApiClient = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()

    _authenticationApi = Retrofit.Builder()
        .baseUrl("https://apps.cactus.school")
        .client(authenticationApiClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(AuthenticationApi::class.java)
}