package com.companytest.jsonplaceholderintegration.di

import com.companytest.jsonplaceholderintegration.domain.TodoDomain
import com.companytest.jsonplaceholderintegration.domain.UserDomain
import com.companytest.jsonplaceholderintegration.model.Todo
import com.companytest.jsonplaceholderintegration.model.User
import com.companytest.jsonplaceholderintegration.proxy.ProxyRepository
import com.companytest.jsonplaceholderintegration.repository.UserRemoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@InstallIn(ActivityRetainedComponent::class)
@Module
object DomainModule {
    @Provides
    fun provideUserDomain(proxyRepository: ProxyRepository<User>): UserDomain{
        return UserDomain(proxyRepository)
    }

    @Provides
    fun provideTodoDomain(proxyRepository: ProxyRepository<Todo>): TodoDomain{
        return TodoDomain(proxyRepository)
    }

}