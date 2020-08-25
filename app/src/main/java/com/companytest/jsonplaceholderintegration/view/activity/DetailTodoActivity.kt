package com.companytest.jsonplaceholderintegration.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.companytest.jsonplaceholderintegration.R
import com.companytest.jsonplaceholderintegration.model.Todo
import com.companytest.jsonplaceholderintegration.viewmodel.DetailTodoViewModel

class DetailTodoActivity : AppCompatActivity() {

    private lateinit var detailTodoViewModel: DetailTodoViewModel
    private lateinit var ivTodoStatus: ImageView
    private lateinit var tvTodoStatus: TextView
    private lateinit var tvTodoTile: TextView

    private lateinit var clLoadingContainer: ConstraintLayout


    private var todoID: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_todo)

        retrieveTodoID()
        initVars()
        initUIComponents()


        detailTodoViewModel.retrieveTodo(todoID)

        executeObservableCode()
    }

    private fun initVars(){
        detailTodoViewModel = ViewModelProvider(this).get(DetailTodoViewModel::class.java)
    }

    private fun initUIComponents(){
        ivTodoStatus = findViewById(R.id.ivTodoStatusDetail)
        tvTodoStatus = findViewById(R.id.tvStatusTodoDetail)
        tvTodoTile = findViewById(R.id.tvTitleTodoDetail)
        clLoadingContainer = findViewById(R.id.clLoadingContainer)

    }

    private fun executeObservableCode(){
        detailTodoViewModel.todo.observe(this, Observer {todo: Todo ->

            if(todo.completed){
                ivTodoStatus.setImageResource(R.drawable.ic_complete_152dp)
                tvTodoStatus.text = "Tarea completada"
            }
            else {
                ivTodoStatus.setImageResource(R.drawable.ic_incomplete_152dp)
                tvTodoStatus.text = "Tarea NO completada"

            }

            tvTodoTile.text = todo.title
        })

        detailTodoViewModel.loading.observe(this, Observer {loading ->
            if(loading) clLoadingContainer.visibility = View.VISIBLE else clLoadingContainer.visibility = View.GONE
        })
    }

    private fun retrieveTodoID(){
        todoID = intent.getStringExtra("todoid")!!
    }
}