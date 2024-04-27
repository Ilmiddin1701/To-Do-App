package com.example.todoapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.todoapp.Models.ToDo
import com.example.todoapp.Utils.MySharedPreference
import com.example.todoapp.databinding.ActivityToDoInfoBinding

class ToDoInfoActivity : AppCompatActivity() {
    private val binding by lazy { ActivityToDoInfoBinding.inflate(layoutInflater) }
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        MySharedPreference.init(this)

        val gPosition = intent.getIntExtra("keyGroup", -1)
        val chPosition = intent.getIntExtra("keyChild", -1)

        binding.apply {
            if (gPosition == 0){
                name.text = MySharedPreference.openList[chPosition].name
                description.text = MySharedPreference.openList[chPosition].description
                if (MySharedPreference.openList[chPosition].degree == 0){
                    degreeFlag.setImageResource(R.drawable.red_flag)
                    degreeText.text = "Urgent"
                }else if (MySharedPreference.openList[chPosition].degree == 1){
                    degreeFlag.setImageResource(R.drawable.yellow_flag)
                    degreeText.text = "High"
                }else if (MySharedPreference.openList[chPosition].degree == 2){
                    degreeFlag.setImageResource(R.drawable.blue_flag)
                    degreeText.text = "Normal"
                }else if (MySharedPreference.openList[chPosition].degree == 3){
                    degreeFlag.setImageResource(R.drawable.gray_flag)
                    degreeText.text = "Low"
                }
                date.text = MySharedPreference.openList[chPosition].date
                deadline.text = MySharedPreference.openList[chPosition].deadline
                radioOpen.isChecked = true
            }else if (gPosition == 1){
                name.text = MySharedPreference.developmentList[chPosition].name
                description.text = MySharedPreference.developmentList[chPosition].description
                if (MySharedPreference.developmentList[chPosition].degree == 0){
                    degreeFlag.setImageResource(R.drawable.red_flag)
                    degreeText.text = "Urgent"
                }else if (MySharedPreference.developmentList[chPosition].degree == 1){
                    degreeFlag.setImageResource(R.drawable.yellow_flag)
                    degreeText.text = "High"
                }else if (MySharedPreference.developmentList[chPosition].degree == 2){
                    degreeFlag.setImageResource(R.drawable.blue_flag)
                    degreeText.text = "Normal"
                }else if (MySharedPreference.developmentList[chPosition].degree == 3){
                    degreeFlag.setImageResource(R.drawable.gray_flag)
                    degreeText.text = "Low"
                }
                date.text = MySharedPreference.developmentList[chPosition].date
                deadline.text = MySharedPreference.developmentList[chPosition].deadline
                radioDevelopment.isChecked = true
            }else if (gPosition == 2){
                name.text = MySharedPreference.uploadingList[chPosition].name
                description.text = MySharedPreference.uploadingList[chPosition].description
                if (MySharedPreference.uploadingList[chPosition].degree == 0){
                    degreeFlag.setImageResource(R.drawable.red_flag)
                    degreeText.text = "Urgent"
                }else if (MySharedPreference.uploadingList[chPosition].degree == 1){
                    degreeFlag.setImageResource(R.drawable.yellow_flag)
                    degreeText.text = "High"
                }else if (MySharedPreference.uploadingList[chPosition].degree == 2){
                    degreeFlag.setImageResource(R.drawable.blue_flag)
                    degreeText.text = "Normal"
                }else if (MySharedPreference.uploadingList[chPosition].degree == 3){
                    degreeFlag.setImageResource(R.drawable.gray_flag)
                    degreeText.text = "Low"
                }
                date.text = MySharedPreference.uploadingList[chPosition].date
                deadline.text = MySharedPreference.uploadingList[chPosition].deadline
                radioUploading.isChecked = true
            }else if (gPosition == 3){
                name.text = MySharedPreference.rejectList[chPosition].name
                description.text = MySharedPreference.rejectList[chPosition].description
                if (MySharedPreference.rejectList[chPosition].degree == 0){
                    degreeFlag.setImageResource(R.drawable.red_flag)
                    degreeText.text = "Urgent"
                }else if (MySharedPreference.rejectList[chPosition].degree == 1){
                    degreeFlag.setImageResource(R.drawable.yellow_flag)
                    degreeText.text = "High"
                }else if (MySharedPreference.rejectList[chPosition].degree == 2){
                    degreeFlag.setImageResource(R.drawable.blue_flag)
                    degreeText.text = "Normal"
                }else if (MySharedPreference.rejectList[chPosition].degree == 3){
                    degreeFlag.setImageResource(R.drawable.gray_flag)
                    degreeText.text = "Low"
                }
                date.text = MySharedPreference.rejectList[chPosition].date
                deadline.text = MySharedPreference.rejectList[chPosition].deadline
                radioReject.isChecked = true
            }else if (gPosition == 4){
                name.text = MySharedPreference.closedList[chPosition].name
                description.text = MySharedPreference.closedList[chPosition].description
                if (MySharedPreference.closedList[chPosition].degree == 0){
                    degreeFlag.setImageResource(R.drawable.red_flag)
                    degreeText.text = "Urgent"
                }else if (MySharedPreference.closedList[chPosition].degree == 1){
                    degreeFlag.setImageResource(R.drawable.yellow_flag)
                    degreeText.text = "High"
                }else if (MySharedPreference.closedList[chPosition].degree == 2){
                    degreeFlag.setImageResource(R.drawable.blue_flag)
                    degreeText.text = "Normal"
                }else if (MySharedPreference.closedList[chPosition].degree == 3){
                    degreeFlag.setImageResource(R.drawable.gray_flag)
                    degreeText.text = "Low"
                }
                date.text = MySharedPreference.closedList[chPosition].date
                deadline.text = MySharedPreference.closedList[chPosition].deadline
                radioClosed.isChecked = true
            }
        }
        binding.apply {
            btnOK.setOnClickListener {
                //radioOpen
                if (gPosition == 0 && radioDevelopment.isChecked){
                    MySharedPreference.init(this@ToDoInfoActivity)
                    val toDo1 = ToDo(
                        MySharedPreference.openList[chPosition].name,
                        MySharedPreference.openList[chPosition].description,
                        MySharedPreference.openList[chPosition].degree,
                        MySharedPreference.openList[chPosition].date,
                        MySharedPreference.openList[chPosition].deadline
                    )
                    val dList = MySharedPreference.developmentList
                    dList.add(toDo1)
                    MySharedPreference.developmentList = dList

                    val rList = MySharedPreference.openList
                    rList.removeAt(chPosition)
                    MySharedPreference.openList = rList

                    Toast.makeText(this@ToDoInfoActivity, "Changed", Toast.LENGTH_SHORT).show()
                    finish()
                }else if (gPosition == 0 && radioUploading.isChecked){
                    MySharedPreference.init(this@ToDoInfoActivity)
                    val toDo1 = ToDo(
                        MySharedPreference.openList[chPosition].name,
                        MySharedPreference.openList[chPosition].description,
                        MySharedPreference.openList[chPosition].degree,
                        MySharedPreference.openList[chPosition].date,
                        MySharedPreference.openList[chPosition].deadline
                    )
                    val uList = MySharedPreference.uploadingList
                    uList.add(toDo1)
                    MySharedPreference.uploadingList = uList

                    val rList = MySharedPreference.openList
                    rList.removeAt(chPosition)
                    MySharedPreference.openList = rList

                    Toast.makeText(this@ToDoInfoActivity, "Changed", Toast.LENGTH_SHORT).show()
                    finish()
                }else if (gPosition == 0 && radioReject.isChecked){
                    MySharedPreference.init(this@ToDoInfoActivity)
                    val toDo1 = ToDo(
                        MySharedPreference.openList[chPosition].name,
                        MySharedPreference.openList[chPosition].description,
                        MySharedPreference.openList[chPosition].degree,
                        MySharedPreference.openList[chPosition].date,
                        MySharedPreference.openList[chPosition].deadline
                    )
                    val rList = MySharedPreference.rejectList
                    rList.add(toDo1)
                    MySharedPreference.rejectList = rList

                    val rList1 = MySharedPreference.openList
                    rList1.removeAt(chPosition)
                    MySharedPreference.openList = rList1

                    Toast.makeText(this@ToDoInfoActivity, "Changed", Toast.LENGTH_SHORT).show()
                    finish()
                }else if (gPosition == 0 && radioClosed.isChecked){
                    MySharedPreference.init(this@ToDoInfoActivity)
                    val toDo1 = ToDo(
                        MySharedPreference.openList[chPosition].name,
                        MySharedPreference.openList[chPosition].description,
                        MySharedPreference.openList[chPosition].degree,
                        MySharedPreference.openList[chPosition].date,
                        MySharedPreference.openList[chPosition].deadline
                    )
                    val uList = MySharedPreference.closedList
                    uList.add(toDo1)
                    MySharedPreference.closedList = uList

                    val rList = MySharedPreference.openList
                    rList.removeAt(chPosition)
                    MySharedPreference.openList = rList

                    Toast.makeText(this@ToDoInfoActivity, "Changed", Toast.LENGTH_SHORT).show()
                    finish()
                }

                //radioDevelopment
                if (gPosition == 1 && radioOpen.isChecked){
                    MySharedPreference.init(this@ToDoInfoActivity)
                    val toDo1 = ToDo(
                        MySharedPreference.developmentList[chPosition].name,
                        MySharedPreference.developmentList[chPosition].description,
                        MySharedPreference.developmentList[chPosition].degree,
                        MySharedPreference.developmentList[chPosition].date,
                        MySharedPreference.developmentList[chPosition].deadline
                    )
                    val oList = MySharedPreference.openList
                    oList.add(toDo1)
                    MySharedPreference.openList = oList

                    val rList = MySharedPreference.developmentList
                    rList.removeAt(chPosition)
                    MySharedPreference.developmentList = rList

                    Toast.makeText(this@ToDoInfoActivity, "Changed", Toast.LENGTH_SHORT).show()
                    finish()
                }else if (gPosition == 1 && radioUploading.isChecked){
                    MySharedPreference.init(this@ToDoInfoActivity)
                    val toDo1 = ToDo(
                        MySharedPreference.developmentList[chPosition].name,
                        MySharedPreference.developmentList[chPosition].description,
                        MySharedPreference.developmentList[chPosition].degree,
                        MySharedPreference.developmentList[chPosition].date,
                        MySharedPreference.developmentList[chPosition].deadline
                    )
                    val uList = MySharedPreference.uploadingList
                    uList.add(toDo1)
                    MySharedPreference.uploadingList = uList

                    val rList = MySharedPreference.developmentList
                    rList.removeAt(chPosition)
                    MySharedPreference.developmentList = rList

                    Toast.makeText(this@ToDoInfoActivity, "Changed", Toast.LENGTH_SHORT).show()
                    finish()
                }else if (gPosition == 1 && radioReject.isChecked){
                    MySharedPreference.init(this@ToDoInfoActivity)
                    val toDo1 = ToDo(
                        MySharedPreference.developmentList[chPosition].name,
                        MySharedPreference.developmentList[chPosition].description,
                        MySharedPreference.developmentList[chPosition].degree,
                        MySharedPreference.developmentList[chPosition].date,
                        MySharedPreference.developmentList[chPosition].deadline
                    )
                    val rList = MySharedPreference.rejectList
                    rList.add(toDo1)
                    MySharedPreference.rejectList = rList

                    val rList1 = MySharedPreference.developmentList
                    rList1.removeAt(chPosition)
                    MySharedPreference.developmentList = rList1

                    Toast.makeText(this@ToDoInfoActivity, "Changed", Toast.LENGTH_SHORT).show()
                    finish()
                }else if (gPosition == 1 && radioClosed.isChecked){
                    MySharedPreference.init(this@ToDoInfoActivity)
                    val toDo1 = ToDo(
                        MySharedPreference.developmentList[chPosition].name,
                        MySharedPreference.developmentList[chPosition].description,
                        MySharedPreference.developmentList[chPosition].degree,
                        MySharedPreference.developmentList[chPosition].date,
                        MySharedPreference.developmentList[chPosition].deadline
                    )
                    val cList = MySharedPreference.closedList
                    cList.add(toDo1)
                    MySharedPreference.closedList = cList

                    val rList = MySharedPreference.developmentList
                    rList.removeAt(chPosition)
                    MySharedPreference.developmentList = rList

                    Toast.makeText(this@ToDoInfoActivity, "Changed", Toast.LENGTH_SHORT).show()
                    finish()
                }

                //radioUploading
                if (gPosition == 2 && radioOpen.isChecked){
                    MySharedPreference.init(this@ToDoInfoActivity)
                    val toDo1 = ToDo(
                        MySharedPreference.uploadingList[chPosition].name,
                        MySharedPreference.uploadingList[chPosition].description,
                        MySharedPreference.uploadingList[chPosition].degree,
                        MySharedPreference.uploadingList[chPosition].date,
                        MySharedPreference.uploadingList[chPosition].deadline
                    )
                    val oList = MySharedPreference.openList
                    oList.add(toDo1)
                    MySharedPreference.openList = oList

                    val rList = MySharedPreference.uploadingList
                    rList.removeAt(chPosition)
                    MySharedPreference.uploadingList = rList

                    Toast.makeText(this@ToDoInfoActivity, "Changed", Toast.LENGTH_SHORT).show()
                    finish()
                }else if (gPosition == 2 && radioDevelopment.isChecked){
                    MySharedPreference.init(this@ToDoInfoActivity)
                    val toDo1 = ToDo(
                        MySharedPreference.uploadingList[chPosition].name,
                        MySharedPreference.uploadingList[chPosition].description,
                        MySharedPreference.uploadingList[chPosition].degree,
                        MySharedPreference.uploadingList[chPosition].date,
                        MySharedPreference.uploadingList[chPosition].deadline
                    )
                    val uList = MySharedPreference.developmentList
                    uList.add(toDo1)
                    MySharedPreference.developmentList = uList

                    val rList = MySharedPreference.uploadingList
                    rList.removeAt(chPosition)
                    MySharedPreference.uploadingList = rList

                    Toast.makeText(this@ToDoInfoActivity, "Changed", Toast.LENGTH_SHORT).show()
                    finish()
                }else if (gPosition == 2 && radioReject.isChecked){
                    MySharedPreference.init(this@ToDoInfoActivity)
                    val toDo1 = ToDo(
                        MySharedPreference.uploadingList[chPosition].name,
                        MySharedPreference.uploadingList[chPosition].description,
                        MySharedPreference.uploadingList[chPosition].degree,
                        MySharedPreference.uploadingList[chPosition].date,
                        MySharedPreference.uploadingList[chPosition].deadline
                    )
                    val rList = MySharedPreference.rejectList
                    rList.add(toDo1)
                    MySharedPreference.rejectList = rList

                    val rList1 = MySharedPreference.uploadingList
                    rList1.removeAt(chPosition)
                    MySharedPreference.uploadingList = rList1

                    Toast.makeText(this@ToDoInfoActivity, "Changed", Toast.LENGTH_SHORT).show()
                    finish()
                }else if (gPosition == 2 && radioClosed.isChecked){
                    MySharedPreference.init(this@ToDoInfoActivity)
                    val toDo1 = ToDo(
                        MySharedPreference.uploadingList[chPosition].name,
                        MySharedPreference.uploadingList[chPosition].description,
                        MySharedPreference.uploadingList[chPosition].degree,
                        MySharedPreference.uploadingList[chPosition].date,
                        MySharedPreference.uploadingList[chPosition].deadline
                    )
                    val cList = MySharedPreference.closedList
                    cList.add(toDo1)
                    MySharedPreference.closedList = cList

                    val rList = MySharedPreference.uploadingList
                    rList.removeAt(chPosition)
                    MySharedPreference.uploadingList = rList

                    Toast.makeText(this@ToDoInfoActivity, "Changed", Toast.LENGTH_SHORT).show()
                    finish()
                }

                //radioReject
                if (gPosition == 3 && radioOpen.isChecked){
                    MySharedPreference.init(this@ToDoInfoActivity)
                    val toDo1 = ToDo(
                        MySharedPreference.rejectList[chPosition].name,
                        MySharedPreference.rejectList[chPosition].description,
                        MySharedPreference.rejectList[chPosition].degree,
                        MySharedPreference.rejectList[chPosition].date,
                        MySharedPreference.rejectList[chPosition].deadline
                    )
                    val oList = MySharedPreference.openList
                    oList.add(toDo1)
                    MySharedPreference.openList = oList

                    val rList = MySharedPreference.rejectList
                    rList.removeAt(chPosition)
                    MySharedPreference.rejectList = rList

                    Toast.makeText(this@ToDoInfoActivity, "Changed", Toast.LENGTH_SHORT).show()
                    finish()
                }else if (gPosition == 3 && radioDevelopment.isChecked){
                    MySharedPreference.init(this@ToDoInfoActivity)
                    val toDo1 = ToDo(
                        MySharedPreference.rejectList[chPosition].name,
                        MySharedPreference.rejectList[chPosition].description,
                        MySharedPreference.rejectList[chPosition].degree,
                        MySharedPreference.rejectList[chPosition].date,
                        MySharedPreference.rejectList[chPosition].deadline
                    )
                    val uList = MySharedPreference.developmentList
                    uList.add(toDo1)
                    MySharedPreference.developmentList = uList

                    val rList = MySharedPreference.rejectList
                    rList.removeAt(chPosition)
                    MySharedPreference.rejectList = rList

                    Toast.makeText(this@ToDoInfoActivity, "Changed", Toast.LENGTH_SHORT).show()
                    finish()
                }else if (gPosition == 3 && radioUploading.isChecked){
                    MySharedPreference.init(this@ToDoInfoActivity)
                    val toDo1 = ToDo(
                        MySharedPreference.rejectList[chPosition].name,
                        MySharedPreference.rejectList[chPosition].description,
                        MySharedPreference.rejectList[chPosition].degree,
                        MySharedPreference.rejectList[chPosition].date,
                        MySharedPreference.rejectList[chPosition].deadline
                    )
                    val rList = MySharedPreference.uploadingList
                    rList.add(toDo1)
                    MySharedPreference.uploadingList = rList

                    val rList1 = MySharedPreference.rejectList
                    rList1.removeAt(chPosition)
                    MySharedPreference.rejectList = rList1

                    Toast.makeText(this@ToDoInfoActivity, "Changed", Toast.LENGTH_SHORT).show()
                    finish()
                }else if (gPosition == 3 && radioClosed.isChecked){
                    MySharedPreference.init(this@ToDoInfoActivity)
                    val toDo1 = ToDo(
                        MySharedPreference.rejectList[chPosition].name,
                        MySharedPreference.rejectList[chPosition].description,
                        MySharedPreference.rejectList[chPosition].degree,
                        MySharedPreference.rejectList[chPosition].date,
                        MySharedPreference.rejectList[chPosition].deadline
                    )
                    val cList = MySharedPreference.closedList
                    cList.add(toDo1)
                    MySharedPreference.closedList = cList

                    val rList = MySharedPreference.rejectList
                    rList.removeAt(chPosition)
                    MySharedPreference.rejectList = rList

                    Toast.makeText(this@ToDoInfoActivity, "Changed", Toast.LENGTH_SHORT).show()
                    finish()
                }

                //radioClosed
                if (gPosition == 4 && radioOpen.isChecked){
                    MySharedPreference.init(this@ToDoInfoActivity)
                    val toDo1 = ToDo(
                        MySharedPreference.closedList[chPosition].name,
                        MySharedPreference.closedList[chPosition].description,
                        MySharedPreference.closedList[chPosition].degree,
                        MySharedPreference.closedList[chPosition].date,
                        MySharedPreference.closedList[chPosition].deadline
                    )
                    val oList = MySharedPreference.openList
                    oList.add(toDo1)
                    MySharedPreference.openList = oList

                    val rList = MySharedPreference.closedList
                    rList.removeAt(chPosition)
                    MySharedPreference.closedList = rList

                    Toast.makeText(this@ToDoInfoActivity, "Changed", Toast.LENGTH_SHORT).show()
                    finish()
                }else if (gPosition == 4 && radioDevelopment.isChecked){
                    MySharedPreference.init(this@ToDoInfoActivity)
                    val toDo1 = ToDo(
                        MySharedPreference.closedList[chPosition].name,
                        MySharedPreference.closedList[chPosition].description,
                        MySharedPreference.closedList[chPosition].degree,
                        MySharedPreference.closedList[chPosition].date,
                        MySharedPreference.closedList[chPosition].deadline
                    )
                    val uList = MySharedPreference.developmentList
                    uList.add(toDo1)
                    MySharedPreference.developmentList = uList

                    val rList = MySharedPreference.closedList
                    rList.removeAt(chPosition)
                    MySharedPreference.closedList = rList

                    Toast.makeText(this@ToDoInfoActivity, "Changed", Toast.LENGTH_SHORT).show()
                    finish()
                }else if (gPosition == 4 && radioUploading.isChecked){
                    MySharedPreference.init(this@ToDoInfoActivity)
                    val toDo1 = ToDo(
                        MySharedPreference.closedList[chPosition].name,
                        MySharedPreference.closedList[chPosition].description,
                        MySharedPreference.closedList[chPosition].degree,
                        MySharedPreference.closedList[chPosition].date,
                        MySharedPreference.closedList[chPosition].deadline
                    )
                    val rList = MySharedPreference.uploadingList
                    rList.add(toDo1)
                    MySharedPreference.uploadingList = rList

                    val rList1 = MySharedPreference.closedList
                    rList1.removeAt(chPosition)
                    MySharedPreference.closedList = rList1

                    Toast.makeText(this@ToDoInfoActivity, "Changed", Toast.LENGTH_SHORT).show()
                    finish()
                }else if (gPosition == 4 && radioReject.isChecked){
                    MySharedPreference.init(this@ToDoInfoActivity)
                    val toDo1 = ToDo(
                        MySharedPreference.closedList[chPosition].name,
                        MySharedPreference.closedList[chPosition].description,
                        MySharedPreference.closedList[chPosition].degree,
                        MySharedPreference.closedList[chPosition].date,
                        MySharedPreference.closedList[chPosition].deadline
                    )
                    val cList = MySharedPreference.rejectList
                    cList.add(toDo1)
                    MySharedPreference.rejectList = cList

                    val rList = MySharedPreference.closedList
                    rList.removeAt(chPosition)
                    MySharedPreference.closedList = rList

                    Toast.makeText(this@ToDoInfoActivity, "Changed", Toast.LENGTH_SHORT).show()
                    finish()
                }
            }
        }
    }
}