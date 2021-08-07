package com.example.cactusnotes.Validations

import com.example.cactusnotes.R
import com.example.cactusnotes.validations.Validator

class LoginPasswordValidator : Validator {
    override fun validate(field: String) = when {
        field.isEmpty() -> R.string.password_is_required
        else -> null
    }
}