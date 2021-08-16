package com.example.cactusnotes.service.model

data class RegisterRequest(
    val email: String,
    val username: String,
    val password: String,
)