package com.companytest.jsonplaceholderintegration.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.companytest.jsonplaceholderintegration.domain.UserDomain
import com.companytest.jsonplaceholderintegration.model.User
import com.companytest.jsonplaceholderintegration.repository.RemoteRepository
import com.companytest.jsonplaceholderintegration.view.adapter.UserAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UserListViewModel @ViewModelInject constructor(var userDomain: UserDomain) :
    ViewModel() {

    var userList: MutableLiveData<ArrayList<User>> = MutableLiveData()
    var loading: MutableLiveData<Boolean> = MutableLiveData()
    var userClick: MutableLiveData<User> = MutableLiveData()

    private lateinit var adapter: UserAdapter


    fun retrieveUserList() {

        viewModelScope.launch {

            var response: ArrayList<User>? = null

            loading.value = true

            withContext(Dispatchers.IO) {
                response = userDomain.retrieveUsers()
            }

            userList.value = response

            loading.value = false

        }
    }

    fun setUsersInAdapter(users: ArrayList<User>) {
        adapter.addUsers(users)
    }

    fun getUserAdapter(): UserAdapter {
        adapter = UserAdapter(this)
        return adapter
    }

    fun getUserAt(position: Int): User? {
        return userList.value?.get(position)
    }

    fun userClickItem(user: User) {
        userClick.value = user
    }
}