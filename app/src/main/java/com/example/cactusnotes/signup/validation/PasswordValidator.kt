package com.example.cactusnotes.signup.validation

import com.example.cactusnotes.R
import com.example.cactusnotes.validation.Validator

class PasswordValidator : Validator {
    override fun validate(field: String) = when {

        field.isEmpty() -> R.string.password_is_required
        field.length < 7 -> R.string.password_is_short
        field.length > 40 -> R.string.password_is_long
        !field.containAtleastONeDigit() -> R.string.password_must_contain
        !field.containAtleastOneLowercase() -> R.string.password_must_contain
        !field.containAtleastOneUppercase() -> R.string.password_must_contain
        field.onSpecial() -> R.string.password_must_contain
        else -> null
    }

     fun String.containAtleastONeDigit() = any { it.isDigit() }
     fun String.containAtleastOneLowercase() = any { it.isLowerCase() }
     fun String.containAtleastOneUppercase() = any { it.isUpperCase() }
     fun String.onSpecial() = !any { it.isDigit() } && !any { it.isLetter() }
}
