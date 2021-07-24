package com.example.cactusnotes

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.cactusnotes.databinding.ActivityLogInBinding

class LogInActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLogInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonCreate.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        binding.buttonLogIn.setOnClickListener {
            if (binding.emailorUsernameTextInputEditText.text.toString() == "") {
                binding.emailorUsernameTextInputEditText.error =
                    getString(R.string.email_or_username_is_required)

                if (binding.passwordLogInTextInputEditText.text.toString() == "") {
                    binding.passwordLogInTextInputEditText.error = getString(R.string.is_required)
                }
            }
        }
    }
}