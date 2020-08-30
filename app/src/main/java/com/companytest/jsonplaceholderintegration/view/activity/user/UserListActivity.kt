package com.companytest.jsonplaceholderintegration.view.activity.user

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.companytest.jsonplaceholderintegration.R
import com.companytest.jsonplaceholderintegration.databinding.ActivityUserListBinding
import com.companytest.jsonplaceholderintegration.model.User
import com.companytest.jsonplaceholderintegration.userId
import com.companytest.jsonplaceholderintegration.viewmodel.UserListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserListActivity : AppCompatActivity() {

    private val userListViewModel: UserListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        title = getString(R.string.userList)

        setupBinding()
        executeObservables()
    }

    private fun setupBinding() {
        var activityUserListBinding: ActivityUserListBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_user_list)
        activityUserListBinding.userListViewModel = userListViewModel
        activityUserListBinding.lifecycleOwner = this
    }

    private fun executeObservables() {
        userListViewModel.retrieveUserList()

        userListViewModel.userList.observe(this, Observer { users: ArrayList<User> ->
            userListViewModel.setUsersInAdapter(users)
        })

        userListViewModel.userClick.observe(this, Observer { user: User ->
            var intent: Intent = Intent(this, UserDetailActivity::class.java)
            intent.putExtra(userId, user.id.toString())
            startActivity(intent)
        })
    }
}