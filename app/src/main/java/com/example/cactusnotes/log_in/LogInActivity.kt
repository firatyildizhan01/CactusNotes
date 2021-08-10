package com.example.cactusnotes.log_in

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.cactusnotes.databinding.ActivityLogInBinding
import com.example.cactusnotes.signup.SignUpActivity
import com.example.cactusnotes.validations.LoginEmailOrUsernameValidator
import com.example.cactusnotes.validations.LoginPasswordValidator
import com.google.android.material.textfield.TextInputLayout

class LogInActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLogInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonLogIn.setOnClickListener {
            isEmailOrUsername()
            isPassword()

        }
        binding.buttonCreate.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }

    private fun validate(textInputLayout: TextInputLayout) {
        val validator = textInputLayout.validator()
        val field = textInputLayout.editText!!.text.toString()
        val error = validator.validate(field)

        if (error == null) {
            textInputLayout.error = null
        } else {
            textInputLayout.error = getString(error)
        }
    }

    private fun TextInputLayout.validator() = when (this) {
        binding.emailorUsernameTextInputLayout -> LoginEmailOrUsernameValidator()
        binding.passwordLogInTextInputLayout -> LoginPasswordValidator()
        else -> throw IllegalArgumentException("No validators are specified for the given TextInputLayout")
    }

    fun isEmailOrUsername() = validate(binding.emailorUsernameTextInputLayout)
    fun isPassword() = validate(binding.passwordLogInTextInputLayout)
}




