package com.example.myapplication

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var notes : MutableSet<String>? = mutableSetOf()

        val sharedPref = getSharedPreferences("MyApp", Context.MODE_PRIVATE)
        notes = sharedPref.getStringSet("NOTE", mutableSetOf())
        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)

        recyclerview.layoutManager = LinearLayoutManager(this)
        var adapter = Adapter(notes!!)
        recyclerview.adapter = adapter

        buttonAdd.setOnClickListener {

            val input = editTextNote.text.toString()

            if (input.isNotEmpty()) {

                notes.add(input)

                editTextNote.setText("")

                sharedPref.edit().putStringSet("NOTE", notes).apply()
                adapter.initNewNotes(notes)


            }

        }

    }
}