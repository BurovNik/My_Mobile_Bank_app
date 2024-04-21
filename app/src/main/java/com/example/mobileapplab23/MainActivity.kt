package com.example.mobileapplab23

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val nextButton: Button = findViewById(R.id.button)
        val userLogin: EditText = findViewById(R.id.editTextText)
        val userPassWord: EditText = findViewById(R.id.editTextTextPassword)
        val authorizationText: TextView = findViewById(R.id.authorizationTextView)
        //val userLogin2: EditText = findViewById(R.id.editTextText2)
        //val userPassWord2: EditText = findViewById(R.id.editTextTextPassword2)





        nextButton.setOnClickListener {
            val login = userLogin.text.toString().trim()
            val pass = userPassWord.text.toString().trim()
            if (login == "" || pass == "")
                Toast.makeText(this, "Введите все поля", Toast.LENGTH_SHORT).show()
            else {
                // val intent = Intent(this, NewsActivity2::class.java)
                val intent = Intent(this, ItemsActivity::class.java)
                startActivity(intent)
            }
        }
        authorizationText.setOnClickListener{
            val intent = Intent(this, RegistrationActivity::class.java)
            startActivity(intent)

        }
    }
}