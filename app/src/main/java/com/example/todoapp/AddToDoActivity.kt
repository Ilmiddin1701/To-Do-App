package com.example.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import com.example.todoapp.Adapters.SpinnerAdapter
import com.example.todoapp.Models.ToDo
import com.example.todoapp.Utils.MySharedPreference
import com.example.todoapp.Utils.obj
import com.example.todoapp.databinding.ActivityAddToDoBinding

class AddToDoActivity : AppCompatActivity() {
    private val binding by lazy { ActivityAddToDoBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.apply {
            val adapter = SpinnerAdapter(obj.list)
            spinner.adapter = adapter

            var degree = 0

            btnSave.setOnClickListener {
                if (toDoName.text.isNotEmpty() && toDoDescription.text.isNotEmpty() && toDoDate.text.isNotEmpty() && toDoDedline.text.isNotEmpty()) {
                    MySharedPreference.init(this@AddToDoActivity)
                    val toDo = ToDo(
                        toDoName.text.toString(),
                        toDoDescription.text.toString(),
                        degree,
                        toDoDate.text.toString(),
                        toDoDedline.text.toString()
                    )
                    val list = MySharedPreference.openList
                    list.add(toDo)
                    MySharedPreference.openList = list
                    Toast.makeText(this@AddToDoActivity, "Saved", Toast.LENGTH_SHORT).show()
                    finish()
                }
            }

            spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    degree = position
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {

                }
            }
        }
    }
}









