package com.companytest.jsonplaceholderintegration.view.activity.user

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.companytest.jsonplaceholderintegration.R
import com.companytest.jsonplaceholderintegration.databinding.ActivityUserDetailBinding
import com.companytest.jsonplaceholderintegration.userId
import com.companytest.jsonplaceholderintegration.viewmodel.UserDetailViewModel

class UserDetailActivity : AppCompatActivity() {

    private lateinit var userDetailVieWModel: UserDetailViewModel
    private lateinit var userID: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setTitle("User detail")

        retrieveUserID()
        initVars()
        setupBinding()

        userDetailVieWModel.retrieveUser(userID)
    }

    fun initVars(){
        userDetailVieWModel = ViewModelProvider(this).get(UserDetailViewModel::class.java)
    }

    private fun setupBinding(){
        val detailUserBinding: ActivityUserDetailBinding = DataBindingUtil.setContentView(this, R.layout.activity_user_detail)
        detailUserBinding.userDetailViewModel = userDetailVieWModel
        detailUserBinding.lifecycleOwner = this
    }

    private fun retrieveUserID(){
        userID = intent.getStringExtra(userId)!!
    }

}