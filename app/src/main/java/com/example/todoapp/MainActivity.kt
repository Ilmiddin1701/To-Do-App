package com.example.todoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.todoapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.apply {
            toDoList.setOnClickListener {
                val intent = Intent(this@MainActivity, ToDoListActivity::class.java)
                startActivity(intent)
            }
            addToDo.setOnClickListener{
                val intent = Intent(this@MainActivity, AddToDoActivity::class.java)
                startActivity(intent)
            }
        }
    }
}