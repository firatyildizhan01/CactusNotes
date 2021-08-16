package com.example.cactusnotes.login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.cactusnotes.R
import com.example.cactusnotes.databinding.ActivityLogInBinding
import com.example.cactusnotes.login.validation.EmailOrUsernameValidator
import com.example.cactusnotes.login.validation.PasswordValidator
import com.example.cactusnotes.service.api
import com.example.cactusnotes.service.model.login.LoginRequest
import com.example.cactusnotes.service.model.login.LoginResponse
import com.example.cactusnotes.signup.SignUpActivity
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputLayout
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLogInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonLogIn.setOnClickListener {
            if (isIdentifierValid() and isPasswordValid()) {
                val identifier = binding.emailorUsernameTextInputEditText.text.toString()
                val password = binding.passwordLogInTextInputEditText.text.toString()

                sendLoginRequest(identifier, password)
            }
        }

        binding.buttonCreate.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }

    private fun sendLoginRequest(identifier: String, password: String) {
        val request = LoginRequest(identifier, password)

        api.login(request).enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                when (response.code()) {
                    200 -> registerSuccess(response.body()!!.jwt)
                    400 -> clientSideError(response)
                    else -> unexpectedError()
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                Snackbar.make(
                    binding.root,
                    R.string.couldnt_connect_to_servers,
                    Snackbar.LENGTH_LONG
                ).show()
            }
        })
    }

    private fun registerSuccess(jwt: String) {
        Snackbar.make(
            binding.root,
            jwt,
            Snackbar.LENGTH_LONG
        ).show()
    }

    private fun unexpectedError() {
        Snackbar.make(
            binding.root,
            R.string.some_error_occurred,
            Snackbar.LENGTH_LONG
        ).show()
    }

    private fun clientSideError(response: Response<LoginResponse>) {
        val responseObj = JSONObject(response.errorBody()!!.string())
        val clientSideErrorMessage = responseObj.getJSONArray("message")
            .getJSONObject(0)
            .getJSONArray("messages")
            .getJSONObject(0)
            .getString("message")

        Snackbar.make(
            binding.root,
            clientSideErrorMessage,
            Snackbar.LENGTH_LONG
        ).show()
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
        binding.emailorUsernameTextInputLayout -> EmailOrUsernameValidator()
        binding.passwordLogInTextInputLayout -> PasswordValidator()
        else -> throw IllegalArgumentException("No validators are specified for the given TextInputLayout")
    }

    private fun isIdentifierValid() = validate(binding.emailorUsernameTextInputLayout)

    private fun isPasswordValid() = validate(binding.passwordLogInTextInputLayout)
}