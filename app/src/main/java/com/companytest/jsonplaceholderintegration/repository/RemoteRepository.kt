package com.companytest.jsonplaceholderintegration.repository

interface RemoteRepository<T> {
    suspend fun getAll(): ArrayList<T>
    suspend fun getById(id: String): T

}