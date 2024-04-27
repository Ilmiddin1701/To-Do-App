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

        val adapter = SpinnerAdapter(obj.list)
        binding.spinner.adapter = adapter

        var degree = 0

        binding.btnSave.setOnClickListener {
            binding.apply {
                if (toDoName.text.isNotEmpty()&&toDoDescription.text.isNotEmpty()&&toDoDate.text.isNotEmpty()&&toDoDedline.text.isNotEmpty()){
                    MySharedPreference.init(this@AddToDoActivity)
                    val toDo = ToDo(
                        binding.toDoName.text.toString(),
                        binding.toDoDescription.text.toString(),
                        degree,
                        binding.toDoDate.text.toString(),
                        binding.toDoDedline.text.toString()
                    )
                    val list = MySharedPreference.openList
                    list.add(toDo)
                    MySharedPreference.openList = list
                    Toast.makeText(this@AddToDoActivity, "Saved", Toast.LENGTH_SHORT).show()
                    finish()
                }
            }

        }

        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                degree = position
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }
    }
}









