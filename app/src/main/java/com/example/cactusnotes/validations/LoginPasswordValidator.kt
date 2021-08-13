package com.example.cactusnotes.validations

import com.example.cactusnotes.R

class LoginPasswordValidator : CactusValidator {
    override fun validate(field: String) = when {
        field.isEmpty() -> R.string.password_is_required
        else -> null
    }
}