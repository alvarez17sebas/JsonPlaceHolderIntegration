package com.companytest.jsonplaceholderintegration.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.companytest.jsonplaceholderintegration.R
import com.companytest.jsonplaceholderintegration.databinding.ActivityDetailTodoBinding
import com.companytest.jsonplaceholderintegration.model.Todo
import com.companytest.jsonplaceholderintegration.viewmodel.DetailTodoViewModel

class DetailTodoActivity : AppCompatActivity() {

    private lateinit var detailTodoViewModel: DetailTodoViewModel
    private var todoID: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


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