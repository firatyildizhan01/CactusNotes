package com.example.cactusnotes.validations

interface CactusValidator {
    fun validate(field: String): Int?
}