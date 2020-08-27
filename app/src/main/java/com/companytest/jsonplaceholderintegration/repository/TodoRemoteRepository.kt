package com.companytest.jsonplaceholderintegration.repository

import com.companytest.jsonplaceholderintegration.model.Todo
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class TodoRemoteRepository @Inject constructor(): RemoteRepository<Todo> {

    private var retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(
        GsonConverterFactory.create()).build()

    private var jsonPlaceHolderService: JsonPlaceHolderService = retrofit.create(JsonPlaceHolderService::class.java)


    override suspend fun getAll(): ArrayList<Todo> {
        return jsonPlaceHolderService.getTodos()
    }

    override suspend fun getById(id: String): Todo {
        return jsonPlaceHolderService.getTodo(id)
    }
}