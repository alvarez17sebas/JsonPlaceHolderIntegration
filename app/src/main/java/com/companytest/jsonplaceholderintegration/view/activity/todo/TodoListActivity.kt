package com.companytest.jsonplaceholderintegration.view.activity.todo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.companytest.jsonplaceholderintegration.R
import com.companytest.jsonplaceholderintegration.databinding.ActivityTodolistBinding
import com.companytest.jsonplaceholderintegration.model.Todo
import com.companytest.jsonplaceholderintegration.viewmodel.TodoListViewModel

class TodoListActivity : AppCompatActivity() {

    private lateinit var todoListViewModel: TodoListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTitle("Todo list")
        initVars()
        setupBindings()
        executeObservableCode()
    }

    private fun initVars(){
        todoListViewModel = ViewModelProvider(this).get(TodoListViewModel::class.java)
    }

    private fun executeObservableCode(){

        todoListViewModel.retrieveTodoList()

        todoListViewModel.todoList.observe(this, Observer {todoList: ArrayList<Todo> ->
            todoListViewModel.setTodoInRecyclerAdapter(todoList)
        })

        todoListViewModel.clickTodoItem.observe(this, Observer {todoItem: Todo ->
            var intent: Intent = Intent(this, DetailTodoActivity::class.java)
            intent.putExtra("todoid", todoItem.id.toString())
            startActivity(intent)
        })
    }

    private fun setupBindings(){
        var activityTodoListBinding: ActivityTodolistBinding =  DataBindingUtil.setContentView(this, R.layout.activity_todolist)
        activityTodoListBinding.todoListViewModel = todoListViewModel
        activityTodoListBinding.lifecycleOwner = this
    }

}