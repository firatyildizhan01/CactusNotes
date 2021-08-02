package com.example.cactusnotes.validations

import com.example.cactusnotes.R

class PasswordValidator : Validator {
    override fun validate(field: String) = when {

        field.isEmpty() -> R.string.password_is_required
        field.length < 7 -> R.string.password_is_short
        field.length > 40 -> R.string.password_is_long
        !field.containAtLeastOneDigit() -> R.string.password_must_contain
        !field.containAtLeastOneLowercase() -> R.string.password_must_contain
        !field.containAtLeastOneUppercase() -> R.string.password_must_contain
        field.onSpecial() -> R.string.password_must_contain
        else -> null
    }

    companion object {
        private fun String.containAtLeastOneDigit() = any { it.isDigit() }
        private fun String.containAtLeastOneLowercase() = any { it.isLowerCase() }
        private fun String.containAtLeastOneUppercase() = any { it.isUpperCase() }
        private fun String.onSpecial() = !any { it.isDigit() } && !any { it.isLetter() }
    }
}
