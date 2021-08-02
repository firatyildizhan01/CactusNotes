package com.example.cactusnotes.Validations

import com.example.cactusnotes.R

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

    public fun String.containAtleastONeDigit() = any { it.isDigit() }
    public fun String.containAtleastOneLowercase() = any { it.isLowerCase() }
    public fun String.containAtleastOneUppercase() = any { it.isUpperCase() }
    public fun String.onSpecial() = !any { it.isDigit() } && !any { it.isLetter() }

}
