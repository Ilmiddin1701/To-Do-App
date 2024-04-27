package com.example.todoapp.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import com.example.todoapp.Models.ToDo
import com.example.todoapp.databinding.ItemChildBinding
import com.example.todoapp.databinding.ItemParentBinding

class MyExpandAdapter(private var titleList:ArrayList<String>, private var map: HashMap<String, ArrayList<ToDo>>): BaseExpandableListAdapter() {
    override fun getGroupCount(): Int {
        return titleList.size
    }

    override fun getChildrenCount(groupPosition: Int): Int {
        return map[titleList[groupPosition]]?.size!!
    }

    override fun getGroup(groupPosition: Int): Any {
        return titleList[groupPosition]
    }

    override fun getChild(groupPosition: Int, childPosition: Int): Any {
        return map[titleList[groupPosition]]?.get(childPosition)!!
    }

    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong()
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return childPosition.toLong()
    }

    override fun hasStableIds(): Boolean {
        return true
    }

    override fun getGroupView(
        groupPosition: Int,
        isExpanded: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {
        val itemParent = ItemParentBinding.inflate(LayoutInflater.from(parent?.context), parent, false)

        itemParent.parentName.text = titleList[groupPosition]

        return itemParent.root
    }

    override fun getChildView(
        groupPosition: Int,
        childPosition: Int,
        isLastChild: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {
        val itemChild = ItemChildBinding.inflate(LayoutInflater.from(parent?.context), parent, false)
        itemChild.itemToDoName.text = map[titleList[groupPosition]]?.get(childPosition)!!.name

        return itemChild.root
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
        return true
    }
}