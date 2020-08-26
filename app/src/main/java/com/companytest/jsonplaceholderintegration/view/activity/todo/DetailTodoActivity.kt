package com.companytest.jsonplaceholderintegration.view.activity.todo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.companytest.jsonplaceholderintegration.R
import com.companytest.jsonplaceholderintegration.databinding.ActivityDetailTodoBinding
import com.companytest.jsonplaceholderintegration.viewmodel.DetailTodoViewModel

class DetailTodoActivity : AppCompatActivity() {

    private lateinit var detailTodoViewModel: DetailTodoViewModel
    private var todoID: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setTitle("Todo detail")

        retrieveTodoID()
        initVars()
        setupBinding()

        detailTodoViewModel.retrieveTodo(todoID)

    }

    private fun initVars(){
        detailTodoViewModel = ViewModelProvider(this).get(DetailTodoViewModel::class.java)
    }

    private fun retrieveTodoID(){
        todoID = intent.getStringExtra("todoid")!!
    }

    private fun setupBinding(){
        var detailTodoBinding: ActivityDetailTodoBinding = DataBindingUtil.setContentView(this, R.layout.activity_detail_todo)
        detailTodoBinding.model = detailTodoViewModel
        detailTodoBinding.lifecycleOwner = this
    }
}