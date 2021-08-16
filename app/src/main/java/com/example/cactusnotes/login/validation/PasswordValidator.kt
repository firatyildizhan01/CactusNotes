package com.example.cactusnotes.login.validation

import com.example.cactusnotes.R
import com.example.cactusnotes.validation.Validator

class PasswordValidator : Validator {
    override fun validate(field: String) = when {
        field.isEmpty() -> R.string.password_is_required
        else -> null
    }
}