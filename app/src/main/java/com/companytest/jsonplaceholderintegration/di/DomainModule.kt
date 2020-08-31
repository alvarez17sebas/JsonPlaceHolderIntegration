package com.companytest.jsonplaceholderintegration.di

import com.companytest.jsonplaceholderintegration.domain.UserDomain
import com.companytest.jsonplaceholderintegration.repository.UserRemoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@InstallIn(ActivityRetainedComponent::class)
@Module
object DomainModule {
    @Provides
    fun provideUserDomain(remoteRepository: UserRemoteRepository): UserDomain{
        return UserDomain(remoteRepository)
    }
}