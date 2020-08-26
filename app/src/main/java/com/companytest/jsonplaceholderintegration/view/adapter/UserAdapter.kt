package com.companytest.jsonplaceholderintegration.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.companytest.jsonplaceholderintegration.R
import com.companytest.jsonplaceholderintegration.model.User
import com.companytest.jsonplaceholderintegration.view.viewholder.UserViewHolder
import com.companytest.jsonplaceholderintegration.viewmodel.UserListViewModel

class UserAdapter(var viewModel: UserListViewModel) : RecyclerView.Adapter<UserViewHolder>() {

    private var data: ArrayList<User> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        var binding: ViewDataBinding = DataBindingUtil.inflate(layoutInflater, viewType, parent, false)
        return UserViewHolder(binding)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bindData(viewModel, position)
    }

    override fun getItemViewType(position: Int): Int {
        return getLayoutForIdPosition()
    }

    private fun getLayoutForIdPosition(): Int{
        return R.layout.item_user
    }

    fun addUsers(users: ArrayList<User>){
        data.addAll(users)
        notifyDataSetChanged()
    }
}