package com.example.cactusnotes.validations

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST


interface SignupAPI {
    @POST("/auth/local/register")// We set endpoint
    fun register(@Body registerRequest: RegisterRequest): Call<RegisterResponse>
}