package com.example.cactusnotes.model

//QUESTIONS
// Q1 Why do we create model files ? what does it mean ?
// Q2 Why do we use data class instance of class
data class RegisterRequest(
    val email: String,
    val username: String,
    val password: String,
)