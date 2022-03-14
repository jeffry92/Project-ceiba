package com.example.project_ceiba.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.project_ceiba.data.model.PostEntity
import com.example.project_ceiba.data.model.UserEntity

@Database(entities = [UserEntity::class, PostEntity::class], version = 1)
abstract class UserDatabase: RoomDatabase() {

    abstract fun userDao(): UserDao
}