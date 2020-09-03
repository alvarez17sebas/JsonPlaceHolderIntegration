package com.companytest.jsonplaceholderintegration.domain

import com.companytest.jsonplaceholderintegration.model.Todo
import com.companytest.jsonplaceholderintegration.proxy.ProxyRepository

class TodoDomain constructor(var proxyRepository: ProxyRepository<Todo>) {

    suspend fun retrieveTodos(): ArrayList<Todo>{
        return proxyRepository.getAll()
    }

    suspend fun retrieveTodo(id: String): Todo{
        return proxyRepository.getById(id)
    }
}