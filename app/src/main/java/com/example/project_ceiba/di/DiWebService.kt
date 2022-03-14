package com.example.project_ceiba.di

import com.example.project_ceiba.domain.Webservice
import com.example.project_ceiba.rest.Constants
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DiWebService {

    @Singleton
    @Provides
    fun injectWebService(): Retrofit{
        return Retrofit.Builder().baseUrl(Constants.URL_BASE)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofitWebService(retrofit: Retrofit): Webservice{
        return retrofit.create(Webservice::class.java)
    }
}