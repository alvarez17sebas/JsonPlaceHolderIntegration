package com.companytest.jsonplaceholderintegration.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.companytest.jsonplaceholderintegration.domain.TodoDomain
import com.companytest.jsonplaceholderintegration.model.Todo
import com.companytest.jsonplaceholderintegration.view.adapter.TodoAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class TodoListViewModel @ViewModelInject constructor(var todoDomain: TodoDomain) :
    ViewModel() {

    var todoList: MutableLiveData<ArrayList<Todo>> = MutableLiveData()
    var loading: MutableLiveData<Boolean> = MutableLiveData()
    var clickTodoItem: MutableLiveData<Todo> = MutableLiveData()

    private lateinit var adapter: TodoAdapter

    fun retrieveTodoList() {

        viewModelScope.launch {

            var responseTodoList: ArrayList<Todo>? = null

            loading.value = true

            withContext(Dispatchers.IO) {
                responseTodoList = todoDomain.retrieveTodos()
            }

            todoList.value = responseTodoList

            loading.value = false
        }
    }

    fun setTodoInRecyclerAdapter(todoList: ArrayList<Todo>) {
        adapter.addTodos(todoList)
    }

    fun getTodoAdapter(): TodoAdapter {
        adapter = TodoAdapter(this)
        return adapter
    }

    fun getTodoAt(position: Int): Todo? {
        val todoItem = todoList.value?.get(position)
        return todoItem
    }

    fun clickTodoItem(todoItem: Todo) {
        clickTodoItem.value = todoItem
    }
}