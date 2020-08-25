package com.companytest.jsonplaceholderintegration.view

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.companytest.jsonplaceholderintegration.BR
import com.companytest.jsonplaceholderintegration.R
import com.companytest.jsonplaceholderintegration.model.Todo
import com.companytest.jsonplaceholderintegration.viewmodel.TodoListViewModel

class TodoViewHolder(binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {

    private var binding: ViewDataBinding? = null

    init {
        this.binding = binding
    }

    fun bindData(todoListViewModel: TodoListViewModel, position: Int){
        binding?.setVariable(BR.model, todoListViewModel)
        binding?.setVariable(BR.position, position)
    }
}