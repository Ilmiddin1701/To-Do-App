package com.example.todoapp.Models

data class ToDo(
    var name: String,
    var description: String,
    var degree: Int,  // 0-Urgent, 1-High, 2-Normal, 3-Low
    var date: String,
    var deadline: String
)
