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

class DetailTodoViewModel : ViewModel() {

    private var remoteRepository: RemoteRepository<Todo> = TodoRemoteRepository()

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