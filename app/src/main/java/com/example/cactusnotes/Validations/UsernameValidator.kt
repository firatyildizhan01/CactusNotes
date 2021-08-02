package com.example.cactusnotes.Validations

import com.example.cactusnotes.R

class UsernameValidator : Validator {
    override fun validate(field: String) = when {
        field.isEmpty() -> R.string.username_is_required
        field.length < 5 -> R.string.username_is_too_short_
        field.length > 50 -> R.string.username_is_too_long_
        !field.all { it.isDigit() || it.isLetter() || it == '_' } -> R.string.username_only_include
        else -> null
    }
}