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


        val nextButton: Button = findViewById(R.id.registrationButton)
        val userLogin: EditText = findViewById(R.id.loginText)
        val userPassWord: EditText = findViewById(R.id.passwordText)
        val registrationTextView: TextView = findViewById(R.id.registrationTextView)
        //val userLogin2: EditText = findViewById(R.id.editTextText2)
        //val userPassWord2: EditText = findViewById(R.id.editTextTextPassword2)





        nextButton.setOnClickListener {
            val login = userLogin.text.toString().trim()
            val pass = userPassWord.text.toString().trim()
            if (login == "" || pass == "")
                Toast.makeText(this, "Введите все поля", Toast.LENGTH_SHORT).show()
            else {
                // val intent = Intent(this, NewsActivity2::class.java)
                val db = DbHelper(this, null)
                val isAuth = db.getUser(login, pass)
                if(isAuth){
                    val intent = Intent(this, ItemsActivity::class.java)
                    startActivity(intent)
                }
                else
                    Toast.makeText(this, "Неверно введен логин или пароль", Toast.LENGTH_SHORT).show()

            }
        }
        registrationTextView.setOnClickListener{
            val intent = Intent(this, RegistrationActivity::class.java)
            startActivity(intent)

        }
    }
}