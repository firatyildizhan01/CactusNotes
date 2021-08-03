package com.example.cactusnotes.Login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.cactusnotes.Validations.loginEmailOrUsernameValidator
import com.example.cactusnotes.Validations.loginPasswordValidator
import com.example.cactusnotes.databinding.ActivityLogInBinding
import com.google.android.material.textfield.TextInputLayout

class logInActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLogInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonLogIn.setOnClickListener {
            validate(binding.emailorUsernameTextInputLayout)
            validate(binding.passwordLogInTextInputLayout)

        }
        binding.buttonCreate.setOnClickListener {
//            val intent = Intent(this, SignUpActivity::class.java)
//            startActivity(intent)
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
        binding.emailorUsernameTextInputLayout -> loginEmailOrUsernameValidator()
        binding.passwordLogInTextInputLayout -> loginPasswordValidator()
        else -> throw IllegalArgumentException("No validators are specified for the given TextInputLayout")
    }
}




