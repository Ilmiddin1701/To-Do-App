package com.example.todoapp.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.todoapp.Models.Spinner
import com.example.todoapp.R

class SpinnerAdapter(private var list: ArrayList<Spinner>?) : BaseAdapter() {
    override fun getCount(): Int = list!!.size

    override fun getItem(position: Int): Any {
        return list!![position]
    }

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val itemView: View
        if (convertView == null) {
            itemView = LayoutInflater.from(parent?.context).inflate(R.layout.degree_item, parent, false)
        }else{
            itemView = convertView
        }

        itemView.findViewById<ImageView>(R.id.item_image)
            .setImageResource(list!![position].image)

        itemView.findViewById<TextView>(R.id.item_name)
            .text = list!![position].name

        return itemView
    }
}