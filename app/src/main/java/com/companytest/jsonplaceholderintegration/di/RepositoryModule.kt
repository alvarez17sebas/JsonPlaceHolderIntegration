package com.companytest.jsonplaceholderintegration.di

import android.content.Context
import com.companytest.jsonplaceholderintegration.model.Todo
import com.companytest.jsonplaceholderintegration.model.User
import com.companytest.jsonplaceholderintegration.proxy.ProxyRepository
import com.companytest.jsonplaceholderintegration.repository.RemoteRepository
import com.companytest.jsonplaceholderintegration.repository.TodoRemoteRepository
import com.companytest.jsonplaceholderintegration.repository.UserRemoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.qualifiers.ApplicationContext

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

    @Provides
    fun bindProxyRepository(@ApplicationContext context: Context, remoteRepository: RemoteRepository<User>): ProxyRepository<User>{
        return ProxyRepository<User>(context, remoteRepository)
    }

    @Provides
    fun bindTodoProxyRepository(@ApplicationContext context: Context, remoteRepository: RemoteRepository<Todo>): ProxyRepository<Todo>{
        return ProxyRepository<Todo>(context, remoteRepository)
    }
}
