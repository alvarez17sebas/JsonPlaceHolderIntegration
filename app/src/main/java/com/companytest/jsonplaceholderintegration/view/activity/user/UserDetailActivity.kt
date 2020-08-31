package com.companytest.jsonplaceholderintegration.view.activity.user

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.companytest.jsonplaceholderintegration.R
import com.companytest.jsonplaceholderintegration.databinding.ActivityUserDetailBinding
import com.companytest.jsonplaceholderintegration.userId
import com.companytest.jsonplaceholderintegration.viewmodel.UserDetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserDetailActivity : AppCompatActivity() {

    private val userDetailVieWModel: UserDetailViewModel by viewModels()
    private lateinit var userID: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        title = getString(R.string.userDetail)

        retrieveUserID()
        setupBinding()

        userDetailVieWModel.retrieveUser(userID)
    }

    private fun setupBinding() {
        val detailUserBinding: ActivityUserDetailBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_user_detail)
        detailUserBinding.userDetailViewModel = userDetailVieWModel
        detailUserBinding.lifecycleOwner = this
    }

    private fun retrieveUserID() {
        userID = intent.getStringExtra(userId)!!
    }

}