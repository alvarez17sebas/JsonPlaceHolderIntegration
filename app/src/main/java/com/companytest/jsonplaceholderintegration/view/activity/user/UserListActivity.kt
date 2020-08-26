package com.companytest.jsonplaceholderintegration.view.activity.user

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.companytest.jsonplaceholderintegration.R
import com.companytest.jsonplaceholderintegration.databinding.ActivityUserListBinding
import com.companytest.jsonplaceholderintegration.model.User
import com.companytest.jsonplaceholderintegration.viewmodel.UserListViewModel

class UserListActivity : AppCompatActivity() {

    private lateinit var userListViewModel: UserListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setTitle("User list")

        initVars()
        setupBinding()

        executeObservables()
    }

    private fun setupBinding(){
        var activityUserListBinding: ActivityUserListBinding = DataBindingUtil.setContentView(this, R.layout.activity_user_list)
        activityUserListBinding.userListViewModel = userListViewModel
        activityUserListBinding.lifecycleOwner = this
    }

    private fun initVars(){
        userListViewModel = ViewModelProvider(this).get(UserListViewModel::class.java)
    }

    private fun executeObservables(){
        userListViewModel.retrieveUserList()

        userListViewModel.userList.observe(this, Observer {users: ArrayList<User> ->
            userListViewModel.setUsersInAdapter(users)
        })

        userListViewModel.userClick.observe(this, Observer { user: User ->
            var intent: Intent = Intent(this, UserDetailActivity::class.java)
            intent.putExtra("userid", user.id.toString())
            startActivity(intent)
        })
    }
}