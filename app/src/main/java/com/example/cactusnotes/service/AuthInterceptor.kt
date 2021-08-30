package com.example.cactusnotes.service

import com.example.cactusnotes.userstore.UserStore
import okhttp3.Interceptor
import okhttp3.Interceptor.Chain
import okhttp3.Response

class AuthInterceptor(private val userStore: UserStore) : Interceptor {
    override fun intercept(chain: Chain): Response {
        val originalRequest = chain.request()

        val jwt = userStore.getJwt() ?: ""

        val modifiedRequest = originalRequest.newBuilder()
            .addHeader("Authorization", "Bearer $jwt")
            .build()

        return chain.proceed(modifiedRequest)
    }
}