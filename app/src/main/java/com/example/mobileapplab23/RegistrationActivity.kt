package com.example.mobileapplab23

import android.content.Intent
import android.os.Bundle
import android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RegistrationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_registration)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val userLogin: EditText = findViewById(R.id.loginText)
        val userEmail: EditText = findViewById(R.id.emailAdressText)
        val userPassword: EditText = findViewById(R.id.passwordText)
        val entranceText: TextView = findViewById(R.id.authorizationTextView)

        val registrationButton: Button = findViewById(R.id.registrationButton)

        registrationButton.setOnClickListener {
            val login = userLogin.text.toString().trim()
            val email = userEmail.text.toString().trim()
            val password = userPassword.text.toString().trim()

            if (login == "" || email == "" || password == "")
                Toast.makeText(this, "Заполните все поля для регистрации", Toast.LENGTH_SHORT).show()
            else {
                val user = User(login, email, password)

                val db = DbHelper(this, null)
                db.addUser(user)
                Toast.makeText(this, "Вы успешно зарегистрировались", Toast.LENGTH_SHORT).show()

                userLogin.text.clear()
                userEmail.text.clear()
                userPassword.text.clear()
            }

        }

        entranceText.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}