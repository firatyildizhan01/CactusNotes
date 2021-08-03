package com.example.cactusnotes.Validations

import com.example.cactusnotes.R

class loginEmailOrUsernameValidator : validator {
    override fun validate(field: String) = when {
        field.isEmpty() -> R.string.email_or_username_is_required
        else -> null
    }


}