package com.companytest.jsonplaceholderintegration.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.companytest.jsonplaceholderintegration.model.Todo
import com.companytest.jsonplaceholderintegration.repository.RemoteRepository
import com.companytest.jsonplaceholderintegration.repository.TodoRemoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class TodoListViewModel : ViewModel() {

    private var remoteRepository: RemoteRepository<Todo> = TodoRemoteRepository()

    var todoList: MutableLiveData<ArrayList<Todo>> = MutableLiveData()
    var loading: MutableLiveData<Boolean> = MutableLiveData()

    fun retrieveTodoList(){

        viewModelScope.launch {

            var responseTodoList: ArrayList<Todo>? = null

            loading.value = true

            withContext(Dispatchers.IO){
                responseTodoList = remoteRepository.getAll()
            }

            todoList.value = responseTodoList

            loading.value = false

        }
    }
}