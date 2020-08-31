package com.companytest.jsonplaceholderintegration.view.viewholder

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.companytest.jsonplaceholderintegration.BR
import com.companytest.jsonplaceholderintegration.viewmodel.TodoListViewModel

class TodoViewHolder(private val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bindData(todoListViewModel: TodoListViewModel, position: Int) {
        binding?.setVariable(BR.model, todoListViewModel)
        binding?.setVariable(BR.position, position)
    }
}