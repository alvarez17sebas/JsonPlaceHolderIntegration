package com.companytest.jsonplaceholderintegration.repository

import com.companytest.jsonplaceholderintegration.model.User
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class UserRemoteRepository @Inject constructor() : RemoteRepository<User> {

    private var retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(
        GsonConverterFactory.create()
    ).build()

    private var jsonPlaceHolderService: JsonPlaceHolderService =
        retrofit.create(JsonPlaceHolderService::class.java)

    override suspend fun getAll(): ArrayList<User> {
        return jsonPlaceHolderService.getUsers()
    }

    override suspend fun getById(id: String): User {
        return jsonPlaceHolderService.getUserById(id)
    }

    override fun toString(): String {
        return UserRemoteRepository::class.java.name
    }
}