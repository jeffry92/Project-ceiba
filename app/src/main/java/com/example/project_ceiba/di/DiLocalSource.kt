package com.example.project_ceiba.di

import android.content.Context
import androidx.room.Room
import com.example.project_ceiba.data.local.UserDao
import com.example.project_ceiba.data.local.UserDatabase
import com.example.project_ceiba.data.local.UserLocalSource
import com.example.project_ceiba.data.local.UserLocalSourceclas
import com.example.project_ceiba.rest.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DiLocalSource {

    @Provides
    @Singleton
    fun injectoLocalSource(userDao: UserDao): UserLocalSource = UserLocalSourceclas(userDao)

    @Provides
    @Singleton
    fun provideUserDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(context,UserDatabase::class.java, Constants.DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()


    @Provides
    fun provideUserDao(dataBase: UserDatabase): UserDao{
        return dataBase.userDao()
    }
}