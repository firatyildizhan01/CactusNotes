package com.example.cactusnotes.service

import com.example.cactusnotes.model.RegisterRequest
import com.example.cactusnotes.model.RegisterResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST


interface SignupAPI {

    // I understood but I still need some explanation about this part

    // as we are making a post request to post a data
    // So we are annotating it with post
    // and along with that we are passing a parameter as users

    @POST("/auth/local/register")// We set endpoint
    //on below line we are creating a method to post our data.
    fun register(@Body registerRequest: RegisterRequest): Call<RegisterResponse>
}