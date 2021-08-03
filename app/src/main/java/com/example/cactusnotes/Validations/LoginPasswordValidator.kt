package com.example.cactusnotes.Validations

import com.example.cactusnotes.R

class loginPasswordValidator : validator {
    override fun validate(field: String) = when {
        field.isEmpty() -> R.string.password_is_required
        else -> null
    }


}