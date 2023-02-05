package com.example.kursovarabota

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        Handler().postDelayed({
            val intent=Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        },2000)
    }
}