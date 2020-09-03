package com.companytest.jsonplaceholderintegration.view.activity

import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.companytest.jsonplaceholderintegration.R
import com.companytest.jsonplaceholderintegration.view.activity.todo.TodoListActivity
import com.companytest.jsonplaceholderintegration.view.activity.user.UserListActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var cm: ConnectivityManager
    private lateinit var activeNetwork: NetworkInfo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        clickEvents()
    }


    private fun clickEvents() {

        flTodoListContainer.setOnClickListener {
            var intent: Intent = Intent(this, TodoListActivity::class.java)
            startActivity(intent)
        }

        flUserListContainer.setOnClickListener {
            var intent: Intent = Intent(this, UserListActivity::class.java)
            startActivity(intent)
        }
    }
}