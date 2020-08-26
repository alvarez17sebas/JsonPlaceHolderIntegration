package com.companytest.jsonplaceholderintegration.view.viewholder

import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.recyclerview.widget.RecyclerView
import com.companytest.jsonplaceholderintegration.viewmodel.UserListViewModel

class UserViewHolder(binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {

    private var binding: ViewDataBinding = binding

    fun bindData(userListViewModel: UserListViewModel, position: Int){
        binding.setVariable(BR.model, userListViewModel)
        binding.setVariable(BR.positionUser, position)
    }
}