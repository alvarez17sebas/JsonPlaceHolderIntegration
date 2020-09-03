package com.companytest.jsonplaceholderintegration.domain

import com.companytest.jsonplaceholderintegration.model.User
import com.companytest.jsonplaceholderintegration.proxy.ProxyRepository
import javax.inject.Inject

class UserDomain @Inject constructor(var proxyRepository: ProxyRepository<User>) {

    suspend fun retrieveUsers(): ArrayList<User> {
        return proxyRepository.getAll()
    }

    suspend fun retrieveUser(id: String): User {
        return proxyRepository.getById(id)
    }
}