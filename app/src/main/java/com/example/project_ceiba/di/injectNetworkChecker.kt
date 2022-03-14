package com.example.project_ceiba.di

import com.example.project_ceiba.core.InternetChecker
import com.example.project_ceiba.core.InternetCheckerclas
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class injectNetworkChecker {

    @Singleton
    @Provides
    fun injectNetworkChecker(): InternetChecker = InternetCheckerclas()
}