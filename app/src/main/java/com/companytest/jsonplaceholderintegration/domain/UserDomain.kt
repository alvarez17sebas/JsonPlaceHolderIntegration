package com.companytest.jsonplaceholderintegration.domain

import com.companytest.jsonplaceholderintegration.model.User
import com.companytest.jsonplaceholderintegration.repository.RemoteRepository
import com.companytest.jsonplaceholderintegration.repository.UserRemoteRepository
import javax.inject.Inject

class UserDomain @Inject constructor(var remoteRepository: RemoteRepository<User>) {

    suspend fun retrieveUsers(): ArrayList<User>{
        return remoteRepository.getAll()
    }

    suspend fun retrieveUser(id: String): User{
        return remoteRepository.getById(id)
    }
}