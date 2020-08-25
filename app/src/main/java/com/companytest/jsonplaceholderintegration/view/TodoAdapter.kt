package com.companytest.jsonplaceholderintegration.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.companytest.jsonplaceholderintegration.R
import com.companytest.jsonplaceholderintegration.model.Todo
import com.companytest.jsonplaceholderintegration.viewmodel.TodoListViewModel

class TodoAdapter(var viewModel: TodoListViewModel) : RecyclerView.Adapter<TodoViewHolder>() {

    private var data: ArrayList<Todo> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {

        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        var binding: ViewDataBinding = DataBindingUtil.inflate(layoutInflater, viewType, parent, false)
        return TodoViewHolder(binding)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {

        holder.bindData(viewModel, position)
    }

    override fun getItemViewType(position: Int): Int {
        return getLayoutIdForPosition()
    }

    private fun getLayoutIdForPosition(): Int{
        return R.layout.item_todo
    }

    fun addTodos(todoList: ArrayList<Todo>){
        data.addAll(todoList)
        notifyDataSetChanged()
    }
}