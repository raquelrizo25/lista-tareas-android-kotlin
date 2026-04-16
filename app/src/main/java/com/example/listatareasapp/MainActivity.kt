package com.example.listatareasapp

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {

    private lateinit var editTextTarea: EditText
    private lateinit var botonAgregar: Button
    private lateinit var listaTareas: ListView

    private val tareas = mutableListOf<String>()
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextTarea = findViewById(R.id.editTextTarea)
        botonAgregar = findViewById(R.id.botonAgregar)
        listaTareas = findViewById(R.id.listaTareas)

        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, tareas)
        listaTareas.adapter = adapter

        botonAgregar.setOnClickListener {
            val nuevaTarea = editTextTarea.text.toString().trim()

            if (nuevaTarea.isNotEmpty()) {
                tareas.add("✔ $nuevaTarea")
                adapter.notifyDataSetChanged()
                editTextTarea.text.clear()
            }
        }
    }
}