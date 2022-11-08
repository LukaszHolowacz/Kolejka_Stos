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

        val addStos = findViewById<Button>(R.id.addStos)
        val removeStos = findViewById<Button>(R.id.removeStos)
        val firstStos = findViewById<Button>(R.id.firstStos)
        val lastStos = findViewById<Button>(R.id.lastStos)
        val wynik = findViewById<TextView>(R.id.wynikStos)
        val stos = LinkedList<Int>()
        val podanaliczba = findViewById<EditText>(R.id.inputStos)
        val back = findViewById<Button>(R.id.backbtn2)
        val zawartosc = findViewById<Button>(R.id.allStos)

        addStos.setOnClickListener {
            if(podanaliczba.text.toString() != ""){
                if (stos.isEmpty()){
                    stos.addFirst(podanaliczba.text.toString().toInt())
                    wynik.text = stos.toString()
                }
                else {
                    stos.add(podanaliczba.text.toString().toInt())
                    wynik.text = stos.toString()
                }
            }
            else{
                Toast.makeText(applicationContext, "Musisz podać jakąś liczbę", Toast.LENGTH_SHORT).show()
            }
        }
        removeStos.setOnClickListener {
            stos.removeLast()
            wynik.text = stos.toString()
        }
        firstStos.setOnClickListener {
            if (stos.isEmpty()){
                Toast.makeText(applicationContext, "Stos jest pusty!", Toast.LENGTH_SHORT).show()
            }
            else{
                wynik.text = stos.first.toString()
            }
        }
        lastStos.setOnClickListener {
            if (stos.isEmpty()){
                Toast.makeText(applicationContext, "Stos jest pusty!", Toast.LENGTH_SHORT).show()
            }
            else{
                wynik.text = stos.last.toString()
            }
        }
        zawartosc.setOnClickListener {
            if (stos.isEmpty()){
                Toast.makeText(applicationContext, "Stos jest pusty!", Toast.LENGTH_SHORT).show()
            }
            else{
                wynik.text = stos.toString()
            }
        }
        back.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}