package com.example.todoapp.Utils

import android.content.Context
import android.content.SharedPreferences
import com.example.todoapp.Models.ToDo
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object MySharedPreference {
    private const val NAME = "catch_file_name"
    private const val MODE = Context.MODE_PRIVATE

    private lateinit var preferences: SharedPreferences

    fun init(context: Context){
        preferences = context.getSharedPreferences(NAME, MODE)
    }

    private inline fun SharedPreferences.edit(operation:(SharedPreferences.Editor) -> Unit){
        val editor = edit()
        operation(editor)
        editor.apply()
    }

    var openList: ArrayList<ToDo>
        get() = gsonStringToList(preferences.getString("openList", "[]")!!)
        set(value) = preferences.edit {
            it.putString("openList", listToGsonString(value))
        }
    var developmentList: ArrayList<ToDo>
        get() = gsonStringToList(preferences.getString("developmentList", "[]")!!)
        set(value) = preferences.edit {
            it.putString("developmentList", listToGsonString(value))
        }
    var uploadingList: ArrayList<ToDo>
        get() = gsonStringToList(preferences.getString("uploadingList", "[]")!!)
        set(value) = preferences.edit {
            it.putString("uploadingList", listToGsonString(value))
        }
    var rejectList: ArrayList<ToDo>
        get() = gsonStringToList(preferences.getString("rejectList", "[]")!!)
        set(value) = preferences.edit {
            it.putString("rejectList", listToGsonString(value))
        }
    var closedList: ArrayList<ToDo>
        get() = gsonStringToList(preferences.getString("closedList", "[]")!!)
        set(value) = preferences.edit {
            it.putString("closedList", listToGsonString(value))
        }

    private fun gsonStringToList(gsonString: String): ArrayList<ToDo>{
        val list = ArrayList<ToDo>()
        val type = object : TypeToken<ArrayList<ToDo>>() {}.type
        list.addAll(Gson().fromJson(gsonString, type))
        return list
    }

    private fun listToGsonString(list:ArrayList<ToDo>): String{
        return Gson().toJson(list)
    }
}