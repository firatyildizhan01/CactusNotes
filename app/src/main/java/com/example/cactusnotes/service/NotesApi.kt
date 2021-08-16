package com.example.cactusnotes.service

import com.example.cactusnotes.service.model.login.LoginRequest
import com.example.cactusnotes.service.model.login.LoginResponse
import com.example.cactusnotes.service.model.register.RegisterRequest
import com.example.cactusnotes.service.model.register.RegisterResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface NotesApi {
    @POST("/auth/local/register")
    fun register(@Body registerRequest: RegisterRequest): Call<RegisterResponse>

    @POST("/auth/local")
    fun login(@Body loginRequest: LoginRequest): Call<LoginResponse>
}