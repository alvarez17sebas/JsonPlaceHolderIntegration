package com.companytest.jsonplaceholderintegration.di

import com.companytest.jsonplaceholderintegration.model.Todo
import com.companytest.jsonplaceholderintegration.model.User
import com.companytest.jsonplaceholderintegration.repository.RemoteRepository
import com.companytest.jsonplaceholderintegration.repository.TodoRemoteRepository
import com.companytest.jsonplaceholderintegration.repository.UserRemoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@InstallIn(ActivityRetainedComponent::class)
@Module
object TodoRepository{
    @Provides
    fun binTodoRepository(): RemoteRepository<Todo> {
        return TodoRemoteRepository()
    }
}

@InstallIn(ActivityRetainedComponent::class)
@Module
object UserRepository{
    @Provides
    fun binTodoRepository(): RemoteRepository<User> {
        return UserRemoteRepository()
    }
}
