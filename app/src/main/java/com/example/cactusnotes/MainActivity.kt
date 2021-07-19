package com.example.cactusnotes
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.contains
import kotlinx.android.synthetic.main.activity_main.*
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonSıgnUp.setOnClickListener {

            if ((emailTextInputEditText.length() > 50
                || emailTextInputEditText.length() < 5)
                || !emailTextInputEditText.text.toString().contains("@", ignoreCase = true)
                || !emailTextInputEditText.text.toString().contains(".", ignoreCase = true))
             {
                emailTextInputEditText.error = "Email is invalid."
             }
            else if (emailTextInputEditText.text.toString() == "") {
                emailTextInputEditText.error = "Email is required."
            }
            if (usernameTextInputEditText.text.toString() == "") {
                usernameTextInputEditText.error = "Username is required."
            }
            else if (usernameTextInputEditText.length() < 2) {
                usernameTextInputEditText.error = "Username is too short."
            }
            else if (usernameTextInputEditText.length() > 20) {
                usernameTextInputEditText.error = "Username is too long."
            }
            else if (!usernameTextInputEditText.text.toString().matches("^[A-Za-z0-9_.]+\$".toRegex()) )
            {
                usernameTextInputEditText.error = "Username can only include a-z, 0-9 and _ characters."
            }
            if (passwordTextInputEditText.text.toString() == "") {
                passwordTextInputEditText.error = "Password is required."
            }
            else if (passwordTextInputEditText.length() < 7) {
                passwordTextInputEditText.error = "Password is too short."
            }
            else if (passwordTextInputEditText.length() > 40) {
                passwordTextInputEditText.error = "Password is too long."
            }
            else if (!passwordTextInputEditText.text.toString()
                    .matches(("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~\$^+=<>])" +
                            ".{8,20}\$").toRegex()))
            {
                passwordTextInputEditText.error ="Password must contain one digit, one uppercase letter" +
                        ", one lowercase letter and one special character."
            }
        }
    }
}

