package com.example.cactusnotes

import android.content.Intent
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.cactusnotes.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonSignUp.setOnClickListener {

            if ((binding.emailTextInputEditText.length() > 50
                        || binding.emailTextInputEditText.length() < 5)
                || !binding.emailTextInputEditText.text.toString().contains("@", ignoreCase = true)
                || !binding.emailTextInputEditText.text.toString().contains(".", ignoreCase = true)
            ) {
                binding.emailTextInputEditText.error = getString(R.string.email_is_invalid)
            } else if (binding.emailTextInputEditText.text.toString() == "") {
                binding.emailTextInputEditText.error = getString(R.string.email_is_required_)
            }
            if (binding.usernameTextInputEditText.text.toString() == "") {
                binding.usernameTextInputEditText.error = getString(R.string.username_is_required)
            } else if (binding.usernameTextInputEditText.length() < 2) {
                binding.usernameTextInputEditText.error = getString(R.string.username_is_too_short_)
            } else if (binding.usernameTextInputEditText.length() > 20) {
                binding.usernameTextInputEditText.error = getString(R.string.username_is_too_long_)
            } else if (!binding.usernameTextInputEditText.text.toString()
                    .matches("^[A-Za-z0-9_.]+\$".toRegex())
            ) {
                binding.usernameTextInputEditText.error = getString(R.string.only_include)
            }
            if (binding.passwordTextInputEditText.text.toString() == "") {
                binding.passwordTextInputEditText.error = getString(R.string.is_required)
            } else if (binding.passwordTextInputEditText.length() < 7) {
                binding.passwordTextInputEditText.error = getString(R.string.is_short)
            } else if (binding.passwordTextInputEditText.length() > 40) {
                binding.passwordTextInputEditText.error = getString(R.string.is_long)
            } else if (!binding.passwordTextInputEditText.text.toString()
                    .matches(
                        ("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~\$^+=<>])" +
                                ".{8,20}\$").toRegex()
                    )
            ) {
                binding.passwordTextInputEditText.error = getString(R.string.must_contain)

            }
        }

        binding.buttonAccount.setOnClickListener {
            val intent = Intent(this, LogInActivity::class.java)
            startActivity(intent)
        }
    }
}

