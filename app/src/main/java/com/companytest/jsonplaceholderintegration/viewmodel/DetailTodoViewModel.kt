package com.companytest.jsonplaceholderintegration.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.companytest.jsonplaceholderintegration.model.Todo
import com.companytest.jsonplaceholderintegration.repository.RemoteRepository
import com.companytest.jsonplaceholderintegration.repository.TodoRemoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DetailTodoViewModel @ViewModelInject constructor(var remoteRepository: RemoteRepository<Todo>) : ViewModel() {

    var todo: MutableLiveData<Todo> = MutableLiveData()
    var loading: MutableLiveData<Boolean> = MutableLiveData()

    fun retrieveTodo(id: String){

        loading.value = true

        viewModelScope.launch {

            var responseTodo: Todo? = null

            withContext(Dispatchers.IO){
                responseTodo = remoteRepository.getById(id)
            }

            todo.value = responseTodo

            loading.value = false

        }
    }
}