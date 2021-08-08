package com.example.cactusnotes.validations

interface Validator {
    fun validate(field: String): Int?

}