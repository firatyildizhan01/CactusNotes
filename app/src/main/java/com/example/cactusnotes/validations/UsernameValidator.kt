package com.example.cactusnotes.validations

import com.example.cactusnotes.R

class UsernameValidator : CactusValidator {
    override fun validate(field: String) = when {
        field.isEmpty() -> R.string.username_is_required
        field.length < 5 -> R.string.username_is_too_short
        field.length > 50 -> R.string.username_is_too_long
        !field.all { it.isDigit() || it.isLetter() || it == '_' } -> R.string.username_only_include
        else -> null
    }
}