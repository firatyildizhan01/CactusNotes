package com.example.cactusnotes.signup

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.cactusnotes.R
import com.example.cactusnotes.databinding.ActivitySignUpBinding
import com.example.cactusnotes.login.LoginActivity
import com.example.cactusnotes.service.api
import com.example.cactusnotes.service.model.RegisterRequest
import com.example.cactusnotes.service.model.RegisterResponse
import com.example.cactusnotes.signup.validation.EmailValidator
import com.example.cactusnotes.signup.validation.PasswordValidator
import com.example.cactusnotes.signup.validation.UsernameValidator
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputLayout
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonSignUp.setOnClickListener {
            if (isEmailValid() && isUsernameValid() && isPasswordValid()) {
                sendRegisterRequest()
            }
        }

        binding.buttonAccount.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }

    private fun validate(textInputLayout: TextInputLayout): Boolean {
        val validator = textInputLayout.validator()
        val field = textInputLayout.editText!!.text.toString()
        val error = validator.validate(field)

        return if (error == null) {
            textInputLayout.error = null
            true
        } else {
            textInputLayout.error = getString(error)
            false
        }
    }

    private fun TextInputLayout.validator() = when (this) {
        binding.emailTextInputLayout -> EmailValidator()
        binding.usernameTextInputLayout -> UsernameValidator()
        binding.passwordTextInputLayout -> PasswordValidator()
        else -> throw IllegalArgumentException("No validators are specified for the given TextInputLayout")
    }

    private fun sendRegisterRequest() {
        val request = RegisterRequest(
            binding.emailTextInputLayout.editText!!.text.toString(),
            binding.usernameTextInputLayout.editText!!.text.toString(),
            binding.passwordTextInputLayout.editText!!.text.toString()
        )

        api.register(request).enqueue(object : Callback<RegisterResponse> {
            override fun onResponse(
                call: Call<RegisterResponse>,
                response: Response<RegisterResponse>
            ) {
                when (response.code()) {
                    in 200..299 -> registerSuccess()
                    in 400..499 -> clientSideError(response)
                    in 500..599 -> serverSideError()
                    else -> Log.e("SignupActivity", "Unexpected error code")
                }
            }

            override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                Snackbar.make(
                    binding.buttonSignUp,
                    R.string.couldnt_connect_to_servers,
                    Snackbar.LENGTH_LONG
                ).show()
            }
        })
    }

    private fun registerSuccess() {
        Snackbar.make(
            binding.buttonSignUp,
            R.string.registered,
            Snackbar.LENGTH_LONG
        ).show()
    }

    private fun serverSideError() {
        Snackbar.make(
            binding.buttonSignUp,
            R.string.some_error_occurred,
            Snackbar.LENGTH_LONG
        ).show()
    }

    private fun clientSideError(response: Response<RegisterResponse>) {
        val responseObj = JSONObject(response.errorBody()!!.string())
        val clientSideErrorMessage = responseObj.getJSONArray("message")
            .getJSONObject(0)
            .getJSONArray("messages")
            .getJSONObject(0)
            .getString("message")

        Snackbar.make(
            binding.buttonSignUp,
            clientSideErrorMessage,
            Snackbar.LENGTH_LONG
        ).show()
    }

    private fun isEmailValid() = validate(binding.emailTextInputLayout)

    private fun isPasswordValid() = validate(binding.passwordTextInputLayout)

    private fun isUsernameValid() = validate(binding.usernameTextInputLayout)
}

