package com.example.cactusnotes.service

import okhttp3.Interceptor
import okhttp3.Response
import userstore.UserStore

class AuthInterceptor(private val userStore: UserStore) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
// need explanation by Mr . Safa
        val requestBuilder = chain.request().newBuilder()

        if (chain.request().url().pathSegments()[0] != "auth") {
            userStore.getJwt()?.let {
                requestBuilder.addHeader("Authorization", "Bearer $it")
            }
        }
        return chain.proceed(requestBuilder.build())
    }
}