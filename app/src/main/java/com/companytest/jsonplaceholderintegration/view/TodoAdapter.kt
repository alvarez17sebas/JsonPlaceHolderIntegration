package com.companytest.jsonplaceholderintegration.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.companytest.jsonplaceholderintegration.R
import com.companytest.jsonplaceholderintegration.model.Todo

class TodoAdapter(var todoItemClick: TodoItemClick) : RecyclerView.Adapter<TodoViewHolder>() {

    private var data: ArrayList<Todo> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_todo, parent, false)
        return TodoViewHolder(view, todoItemClick)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        var todoItem: Todo = data[position]
        holder.binData(todoItem)
    }

    fun addTodos(todoList: ArrayList<Todo>){
        data.clear()
        data = todoList
        notifyDataSetChanged()
    }
}