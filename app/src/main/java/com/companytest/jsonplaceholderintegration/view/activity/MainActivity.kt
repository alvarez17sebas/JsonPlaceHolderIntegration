package com.companytest.jsonplaceholderintegration.view.activity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.companytest.jsonplaceholderintegration.R
import com.companytest.jsonplaceholderintegration.view.activity.todo.TodoListActivity
import com.companytest.jsonplaceholderintegration.view.activity.user.UserListActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.reflect.KClass

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        clickEvents()
    }

    private fun clickEvents(){

        btnTodoList.setOnClickListener{
            var intent: Intent = Intent(this, TodoListActivity::class.java)
            startActivity(intent)
        }

        btnUserList.setOnClickListener {
            var intent: Intent = Intent(this, UserListActivity::class.java)
            startActivity(intent)
        }
    }
}