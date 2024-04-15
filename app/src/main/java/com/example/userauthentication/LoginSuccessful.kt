package com.example.userauthentication

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.Firebase
import com.google.firebase.auth.auth

class LoginSuccessful : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login_successful)



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        checkCurrentUser()
    }

    private fun checkCurrentUser() {
        // [START check_current_user]
        val user = Firebase.auth.currentUser
        if (user != null) {
            val email: TextView = findViewById(R.id.txtEmail)
            email.text = email.text.toString()
        } else {
            // No user is signed in
        }
        // [END check_current_user]
    }
}