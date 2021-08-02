package com.example.cactusnotes.Validations

interface Validator {
    fun validate(field: String): Int?

}