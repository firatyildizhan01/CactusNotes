package com.example.cactusnotes.signup

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.cactusnotes.Login.LogInActivity
import com.example.cactusnotes.databinding.ActivitySignUpBinding
import com.example.cactusnotes.validations.*

import com.google.android.material.textfield.TextInputLayout
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding

    val api: SignupAPI by lazy {
        Retrofit.Builder()
            .baseUrl("https://apps.cactus.school")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(SignupAPI::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonSignUp.setOnClickListener {

            validate(binding.emailTextInputLayout)
            validate(binding.usernameTextInputLayout)
            validate(binding.passwordTextInputLayout)

        }
        binding.buttonAccount.setOnClickListener {
            val intent = Intent(this, LogInActivity::class.java)
            startActivity(intent)
        }
        api.register(RegisterRequest())
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
        binding.emailTextInputLayout -> EmailValidator()
        binding.usernameTextInputLayout -> UsernameValidator()
        binding.passwordTextInputLayout -> PasswordValidator()
        else -> throw IllegalArgumentException("No validators are specified for the given TextInputLayout")
    }
}