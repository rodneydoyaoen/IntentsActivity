package com.example.loginactivity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.loginBtn).setOnClickListener{ loginToAct() }

    }
    private fun loginToAct(){

        val un = findViewById<EditText>(R.id.usernameField)
        val pw = findViewById<EditText>(R.id.passwordField)

        val checkun = un.text
        val checkpw = pw.text

        if (checkun.toString() == "admin" && checkpw.toString() == "2135"){
            val intent = Intent(this, TaskActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Login successful.", Toast.LENGTH_LONG).show()
        }
        else{
            Toast.makeText(this, "Invalid username and password.", Toast.LENGTH_LONG).show()
        }
    }
}