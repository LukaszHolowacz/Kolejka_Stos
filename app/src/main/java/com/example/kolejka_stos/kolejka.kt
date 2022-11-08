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
        val podanytext = findViewById<EditText>(R.id.inputKolejka)
        val wynik = findViewById<TextView>(R.id.wynikKolejka)


        val wszystko = findViewById<Button>(R.id.allKolejka)
        wszystko.setOnClickListener {
            if(!kolejka.isEmpty()){
                wynik.text = kolejka.toString()
            }
            else{
                Toast.makeText(applicationContext, "Kolejka jest pusta!", Toast.LENGTH_SHORT).show()
            }
        }

        val first = findViewById<Button>(R.id.firstKolejka)
        first.setOnClickListener {
            if(!kolejka.isEmpty()){
                wynik.text = kolejka.peek().toString()
            }
            else{
                Toast.makeText(applicationContext, "Kolejka jest pusta!", Toast.LENGTH_SHORT).show()
            }
        }

        val last = findViewById<Button>(R.id.lastKolejka)
        last.setOnClickListener {
            if(!kolejka.isEmpty()){
                wynik.text = kolejka.last().toString()
            }
            else{
                Toast.makeText(applicationContext, "Kolejka jest pusta!", Toast.LENGTH_SHORT).show()
            }
        }

        val add = findViewById<Button>(R.id.addKolejka)
        add.setOnClickListener {
            if(podanytext.text.toString() != "") {
                kolejka.add(podanytext.text.toString().toInt())
                wynik.text = kolejka.toString()
                podanytext.text.clear()
            }
            else{
                Toast.makeText(applicationContext, "Musisz podać jakąś liczbę!", Toast.LENGTH_SHORT).show()
            }
        }

        val remove = findViewById<Button>(R.id.removeKolejka)
        remove.setOnClickListener {
            kolejka.poll()
            wynik.text = kolejka.toString()
        }

        val back = findViewById<Button>(R.id.backbtn)
        back.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}