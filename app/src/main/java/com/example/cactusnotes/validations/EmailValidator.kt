package com.example.cactusnotes.Validations

import com.example.cactusnotes.R
import com.example.cactusnotes.validations.Validator

class EmailValidator : Validator {
    override fun validate(field: String) = when {
        field.isEmpty() -> R.string.email_is_required
        field.length < 5 -> R.string.email_is_invalid
        field.length > 50 -> R.string.email_is_invalid
        !(field.contains("@") && field.contains(".")) -> R.string.email_is_invalid
        else -> null
    }
}