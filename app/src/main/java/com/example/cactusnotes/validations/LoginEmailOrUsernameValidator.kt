package com.example.cactusnotes.Validations

import com.example.cactusnotes.R
import com.example.cactusnotes.validations.Validator

class LoginEmailOrUsernameValidator : Validator {
    override fun validate(field: String) = when {
        field.isEmpty() -> R.string.email_or_username_is_required
        else -> null
    }
}