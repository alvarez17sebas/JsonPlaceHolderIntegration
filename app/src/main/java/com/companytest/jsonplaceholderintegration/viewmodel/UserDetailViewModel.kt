package com.companytest.jsonplaceholderintegration.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.companytest.jsonplaceholderintegration.model.User
import com.companytest.jsonplaceholderintegration.repository.RemoteRepository
import com.companytest.jsonplaceholderintegration.repository.UserRemoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UserDetailViewModel : ViewModel() {

    val repository: RemoteRepository<User> = UserRemoteRepository()

    var user: MutableLiveData<User> = MutableLiveData()
    val loading: MutableLiveData<Boolean> = MutableLiveData()

    fun retrieveUser(id: String){
        viewModelScope.launch {

            var response: User? = null
            loading.value = true

            withContext(Dispatchers.IO){
                response = repository.getById(id)
            }
            user.value = response
            loading.value = false

        }
    }
}