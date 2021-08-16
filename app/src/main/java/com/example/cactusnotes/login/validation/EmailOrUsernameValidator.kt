package com.example.cactusnotes.login.validation

import com.example.cactusnotes.R
import com.example.cactusnotes.validation.Validator

class EmailOrUsernameValidator : Validator {
    override fun validate(field: String) = when {
        field.isEmpty() -> R.string.email_or_username_is_required
        else -> null
    }
}