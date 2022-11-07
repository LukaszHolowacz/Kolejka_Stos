package com.example.kolejka_stos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val kolejkabtn = findViewById<Button>(R.id.kolejkabtn)
        val stosbtn = findViewById<Button>(R.id.stosbtn)

        kolejkabtn.setOnClickListener {
            val intent = Intent(this,kolejka::class.java)
            startActivity(intent)
        }
        stosbtn.setOnClickListener {
            val intent = Intent(this,stos::class.java)
            startActivity(intent)
        }
    }
}