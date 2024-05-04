package com.example.todoapp.Utils

import com.example.todoapp.Models.Spinner
import com.example.todoapp.R

object obj {
    val images = intArrayOf(
        R.drawable.red_flag,
        R.drawable.yellow_flag,
        R.drawable.blue_flag,
        R.drawable.gray_flag
    )
    val degrees = arrayOf(
        "Urgent",
        "High",
        "Normal",
        "Low"
    )
    var list: ArrayList<Spinner>? = null
        get() {
            if (field != null) {
                return field
            }
            field = ArrayList()
            for (i in images.indices) {
                val image = images[i]
                val name = degrees[i]
                val degree = Spinner(image, name)
                field!!.add(degree)
            }
            return field
        }
}