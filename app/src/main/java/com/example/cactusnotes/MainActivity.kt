package com.example.cactusnotes
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.contains
import com.example.cactusnotes.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //binding  = ActivityMainBinding.inflate(layoutInflater)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonSignUp.setOnClickListener {

            if ((binding.emailTextInputEditText.length() > 50
                || binding.emailTextInputEditText.length() < 5)
                || !binding.emailTextInputEditText.text.toString().contains("@", ignoreCase = true)
                || !binding.emailTextInputEditText.text.toString().contains(".", ignoreCase = true))
             {
                 binding.emailTextInputEditText.error = "Email is invalid."
             }
            else if (binding.emailTextInputEditText.text.toString() == "") {
                binding.emailTextInputEditText.error = "Email is required."
            }
            if (binding.usernameTextInputEditText.text.toString() == "") {
                binding.usernameTextInputEditText.error = "Username is required."
            }
            else if (binding.usernameTextInputEditText.length() < 2) {
                binding.usernameTextInputEditText.error = "Username is too short."
            }
            else if (binding.usernameTextInputEditText.length() > 20) {
                binding.usernameTextInputEditText.error = "Username is too long."
            }
            else if (!binding.usernameTextInputEditText.text.toString().matches("^[A-Za-z0-9_.]+\$".toRegex()) )
            {
                binding.usernameTextInputEditText.error = "Username can only include a-z, 0-9 and _ characters."
            }
            if (binding.passwordTextInputEditText.text.toString() == "") {
                binding.passwordTextInputEditText.error = "Password is required."
            }
            else if (binding.passwordTextInputEditText.length() < 7) {
                binding.passwordTextInputEditText.error = "Password is too short."
            }
            else if (binding.passwordTextInputEditText.length() > 40) {
                binding.passwordTextInputEditText.error = "Password is too long."
            }
            else if (!binding.passwordTextInputEditText.text.toString()
                    .matches(("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~\$^+=<>])" +
                            ".{8,20}\$").toRegex()))
            {
                binding.passwordTextInputEditText.error ="Password must contain one digit, one uppercase letter" +
                        ", one lowercase letter and one special character."
            }
        }
    }
}

