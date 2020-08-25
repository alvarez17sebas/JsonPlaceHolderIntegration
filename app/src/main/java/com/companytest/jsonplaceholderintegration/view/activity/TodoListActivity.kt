package com.companytest.jsonplaceholderintegration.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.companytest.jsonplaceholderintegration.R
import com.companytest.jsonplaceholderintegration.model.Todo
import com.companytest.jsonplaceholderintegration.view.TodoAdapter
import com.companytest.jsonplaceholderintegration.view.TodoItemClick
import com.companytest.jsonplaceholderintegration.viewmodel.TodoListViewModel

class TodoListActivity : AppCompatActivity(), TodoItemClick {

    private lateinit var todoListViewModel: TodoListViewModel
    private lateinit var rvTodoList: RecyclerView
    private lateinit var clLoadingContainer: ConstraintLayout
    private lateinit var todoAdapter: TodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todolist)

        initVars()
        initUIComponents()
        setupRecyclerView()

        todoListViewModel.retrieveTodoList()

        executeObservableCode()
    }

    private fun initVars(){
        todoListViewModel = ViewModelProvider(this).get(TodoListViewModel::class.java)
        todoAdapter = TodoAdapter(this)
    }

    private fun initUIComponents(){
        rvTodoList = findViewById(R.id.rvTodoList)
        clLoadingContainer = findViewById(R.id.clLoadingContainer)
    }

    private fun setupRecyclerView(){
        var layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        rvTodoList.layoutManager = layoutManager
        rvTodoList.adapter = todoAdapter
    }

    private fun executeObservableCode(){
        todoListViewModel.todoList.observe(this, Observer {todoList: ArrayList<Todo> ->
            todoAdapter.addTodos(todoList)
        })

        todoListViewModel.loading.observe(this, Observer {loading ->
            if(loading) clLoadingContainer.visibility = View.VISIBLE else clLoadingContainer.visibility = View.GONE
        })
    }

    override fun todoClickItem(todoItem: Todo) {
        var intent: Intent = Intent(this, DetailTodoActivity::class.java)
        intent.putExtra("todoid", todoItem.id.toString())
        startActivity(intent)
    }
}