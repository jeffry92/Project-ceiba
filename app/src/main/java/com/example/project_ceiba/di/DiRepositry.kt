package com.example.project_ceiba.di

import com.example.project_ceiba.core.InternetChecker
import com.example.project_ceiba.data.local.UserLocalSource
import com.example.project_ceiba.data.local.UserLocalSourceclas
import com.example.project_ceiba.data.remote.UserApiSource
import com.example.project_ceiba.domain.UserRepositoryclas
import com.example.project_ceiba.domain.UserReposity
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DiRepositry {

    @Provides
    @Singleton
    fun injectRepositry(userApiSource: UserApiSource,
                        userLocalSource: UserLocalSource,
                        internetChecker: InternetChecker
    ): UserReposity = UserRepositoryclas(userApiSource,userLocalSource,internetChecker)
}