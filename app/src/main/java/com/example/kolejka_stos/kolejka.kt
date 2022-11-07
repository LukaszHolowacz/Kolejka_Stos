package com.example.kolejka_stos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.util.*

class kolejka : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kolejka)

        val kolejka: Queue<Int> = LinkedList<Int>()
        val add = findViewById<Button>(R.id.addKolejka)
        val remove = findViewById<Button>(R.id.removeKolejka)
        val wszystko = findViewById<Button>(R.id.allKolejka)
        val first = findViewById<Button>(R.id.firstKolejka)
        val last = findViewById<Button>(R.id.lastKolejka)
        val podanytext = findViewById<EditText>(R.id.inputKolejka)
        val wynik = findViewById<TextView>(R.id.wynikKolejka)
        val back = findViewById<Button>(R.id.backbtn)

        wszystko.setOnClickListener {
            if(!kolejka.isEmpty()){
                wynik.text = kolejka.toString()
            }
            else{
                Toast.makeText(applicationContext, "Kolejka jest pusta!", Toast.LENGTH_LONG).show()
            }
        }
        first.setOnClickListener {
            if(!kolejka.isEmpty()){
                wynik.text = kolejka.peek().toString()
            }
            else{
                Toast.makeText(applicationContext, "Kolejka jest pusta!", Toast.LENGTH_LONG).show()
            }
        }
        last.setOnClickListener {
            if(!kolejka.isEmpty()){
                wynik.text = kolejka.last().toString()
            }
            else{
                Toast.makeText(applicationContext, "Kolejka jest pusta!", Toast.LENGTH_LONG).show()
            }
        }
        add.setOnClickListener {
            if(podanytext.text.toString() != "") {
                kolejka.add(podanytext.text.toString().toInt())
                Toast.makeText(applicationContext, "Dodano podaną liczbę do kolejki!", Toast.LENGTH_LONG).show()
            }
            else{
                Toast.makeText(applicationContext, "Musisz podać jakąś liczbę!", Toast.LENGTH_LONG).show()
            }
        }
        remove.setOnClickListener {
            kolejka.poll()
        }
        back.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}