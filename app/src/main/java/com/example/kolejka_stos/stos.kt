package com.example.kolejka_stos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.util.*

class stos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stos)

        val stos = Stack<Int>()
        val wynik = findViewById<TextView>(R.id.wynikStos)
        val podanaliczba = findViewById<EditText>(R.id.inputStos)


        val addStos = findViewById<Button>(R.id.addStos)
        addStos.setOnClickListener {
            if(podanaliczba.text.toString() != ""){
                stos.add(podanaliczba.text.toString().toInt())
                wynik.text = stos.toString()
            }
            else{
                Toast.makeText(applicationContext, "Musisz podać jakąś liczbę", Toast.LENGTH_SHORT).show()
            }
        }

        val removeStos = findViewById<Button>(R.id.removeStos)
        removeStos.setOnClickListener {
            stos.removeLast()
            wynik.text = stos.toString()
        }

        val firstStos = findViewById<Button>(R.id.firstStos)
        firstStos.setOnClickListener {
            if (stos.isEmpty()){
                Toast.makeText(applicationContext, "Stos jest pusty!", Toast.LENGTH_SHORT).show()
            }
            else{
                wynik.text = stos.get(0).toString()
            }
        }

        val lastStos = findViewById<Button>(R.id.lastStos)
        lastStos.setOnClickListener {
            if (stos.isEmpty()){
                Toast.makeText(applicationContext, "Stos jest pusty!", Toast.LENGTH_SHORT).show()
            }
            else{
                wynik.text = stos.lastElement().toString()
            }
        }

        val zawartosc = findViewById<Button>(R.id.allStos)
        zawartosc.setOnClickListener {
            if (stos.isEmpty()){
                Toast.makeText(applicationContext, "Stos jest pusty!", Toast.LENGTH_SHORT).show()
            }
            else{
                wynik.text = stos.toString()
            }
        }

        val back = findViewById<Button>(R.id.backbtn2)
        back.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}