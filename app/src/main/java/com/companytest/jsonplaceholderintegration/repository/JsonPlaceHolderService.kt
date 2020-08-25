package com.companytest.jsonplaceholderintegration.repository

import com.companytest.jsonplaceholderintegration.model.Todo
import com.companytest.jsonplaceholderintegration.model.User
import retrofit2.http.GET
import retrofit2.http.Path

interface JsonPlaceHolderService {

    @GET("todos")
    suspend fun getTodos(): ArrayList<Todo>

    @GET("todos/{id}")
    suspend fun getTodo(@Path("id") id: String): Todo

    @GET("users")
    suspend fun getUsers(): ArrayList<User>

    @GET("users/{id}")
    suspend fun getUserById(@Path("id") id: String): User
}