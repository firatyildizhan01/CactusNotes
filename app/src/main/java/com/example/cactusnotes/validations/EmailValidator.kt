package com.example.cactusnotes.validations

import com.example.cactusnotes.R

class EmailValidator : CactusValidator {
    override fun validate(field: String) = when {
        field.isEmpty() -> R.string.email_is_required
        field.length < 5 -> R.string.email_is_invalid
        field.length > 50 -> R.string.email_is_invalid
        !(field.contains("@") && field.contains(".")) -> R.string.email_is_invalid
        else -> null
    }
}