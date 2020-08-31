package com.companytest.jsonplaceholderintegration.view.activity.todo

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.companytest.jsonplaceholderintegration.R
import com.companytest.jsonplaceholderintegration.databinding.ActivityTodolistBinding
import com.companytest.jsonplaceholderintegration.model.Todo
import com.companytest.jsonplaceholderintegration.todoId
import com.companytest.jsonplaceholderintegration.viewmodel.TodoListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TodoListActivity : AppCompatActivity() {

    private val todoListViewModel: TodoListViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        title = getString(R.string.todolist)

        setupBindings()
        executeObservableCode()
    }

    private fun executeObservableCode() {

        todoListViewModel.retrieveTodoList()

        todoListViewModel.todoList.observe(this, Observer { todoList: ArrayList<Todo> ->
            todoListViewModel.setTodoInRecyclerAdapter(todoList)
        })

        todoListViewModel.clickTodoItem.observe(this, Observer { todoItem: Todo ->
            val intent: Intent = Intent(this, DetailTodoActivity::class.java)
            intent.putExtra(todoId, todoItem.id.toString())
            startActivity(intent)
        })
    }

    private fun setupBindings() {
        var activityTodoListBinding: ActivityTodolistBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_todolist)
        activityTodoListBinding.todoListViewModel = todoListViewModel
        activityTodoListBinding.lifecycleOwner = this
    }

}