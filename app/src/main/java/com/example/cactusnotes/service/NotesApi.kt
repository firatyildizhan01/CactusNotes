package com.example.cactusnotes.service

import com.example.cactusnotes.model.RegisterRequest
import com.example.cactusnotes.model.RegisterResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface NotesApi {
    @POST("/auth/local/register")
    fun register(@Body registerRequest: RegisterRequest): Call<RegisterResponse>
}