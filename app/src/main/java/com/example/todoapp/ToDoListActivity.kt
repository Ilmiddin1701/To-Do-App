package com.example.todoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.todoapp.Adapters.MyExpandAdapter
import com.example.todoapp.Models.ToDo
import com.example.todoapp.Utils.MySharedPreference
import com.example.todoapp.databinding.ActivityToDoListBinding
import java.lang.NullPointerException

class ToDoListActivity : AppCompatActivity() {
    private val binding by lazy { ActivityToDoListBinding.inflate(layoutInflater) }
    private lateinit var titleList: ArrayList<String>
    private lateinit var myExpandAdapter: MyExpandAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

    }

    override fun onResume() {
        super.onResume()

        MySharedPreference.init(this)

        try {
            titleList = arrayListOf("Open", "Development", "Uploading", "Reject", "Closed")
            val map = HashMap<String, ArrayList<ToDo>>()

            map[titleList[0]] = MySharedPreference.openList
            map[titleList[1]] = MySharedPreference.developmentList
            map[titleList[2]] = MySharedPreference.uploadingList
            map[titleList[3]] = MySharedPreference.rejectList
            map[titleList[4]] = MySharedPreference.closedList

            myExpandAdapter = MyExpandAdapter(titleList, map)
            binding.expand.setAdapter(myExpandAdapter)
        }catch (e: NullPointerException){
            Toast.makeText(this, "Add information", Toast.LENGTH_SHORT).show()
        }

        binding.expand.setOnChildClickListener { parent, v, groupPosition, childPosition, id ->
            val intent = Intent(this@ToDoListActivity, ToDoInfoActivity::class.java)
            intent.putExtra("keyGroup", groupPosition)
            intent.putExtra("keyChild", childPosition)
            startActivity(intent)
            true
        }
    }
}