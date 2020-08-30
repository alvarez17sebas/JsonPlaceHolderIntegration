package com.companytest.jsonplaceholderintegration.view.activity.todo

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.companytest.jsonplaceholderintegration.R
import com.companytest.jsonplaceholderintegration.databinding.ActivityDetailTodoBinding
import com.companytest.jsonplaceholderintegration.todoId
import com.companytest.jsonplaceholderintegration.viewmodel.DetailTodoViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailTodoActivity : AppCompatActivity() {

    private val detailTodoViewModel: DetailTodoViewModel by viewModels()
    private var todoID: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        title = getString(R.string.todoDetail)

        retrieveTodoID()
        setupBinding()

        detailTodoViewModel.retrieveTodo(todoID)

    }

    private fun retrieveTodoID() {
        todoID = intent.getStringExtra(todoId)!!
    }

    private fun setupBinding() {
        var detailTodoBinding: ActivityDetailTodoBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_detail_todo)
        detailTodoBinding.model = detailTodoViewModel
        detailTodoBinding.lifecycleOwner = this
    }
}