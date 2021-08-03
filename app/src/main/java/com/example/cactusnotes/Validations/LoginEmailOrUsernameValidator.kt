package com.example.cactusnotes.validations

import com.example.cactusnotes.R

class LoginEmailOrUsernameValidator : Validator {
    override fun validate(field: String) = when {
        field.isEmpty() -> R.string.email_or_username_is_required
        else -> null
    }
}