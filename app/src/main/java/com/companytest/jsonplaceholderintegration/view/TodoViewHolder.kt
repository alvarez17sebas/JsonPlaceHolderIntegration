package com.companytest.jsonplaceholderintegration.view

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.companytest.jsonplaceholderintegration.R
import com.companytest.jsonplaceholderintegration.model.Todo

class TodoViewHolder(itemView: View, var todoItemClick: TodoItemClick) : RecyclerView.ViewHolder(itemView) {

    private var cardView: CardView = itemView.findViewById(R.id.cvContainerTodoItem)
    private var tvTodoTitle: TextView = itemView.findViewById(R.id.tvTitleTodo)
    private var ivTodoStatus: ImageView =  itemView.findViewById(R.id.ivTodoStatus)

    private lateinit var todoItem: Todo

    init {
        clickEvents()
    }

    fun binData(todoItem: Todo){
        this.todoItem = todoItem
        tvTodoTitle.text = todoItem.title

        if(todoItem.completed) ivTodoStatus.setImageResource(R.drawable.ic_complete) else ivTodoStatus.setImageResource(R.drawable.ic_incomplete)
    }

    private fun clickEvents(){
        cardView.setOnClickListener {
            todoItemClick.todoClickItem(todoItem)
        }
    }

}