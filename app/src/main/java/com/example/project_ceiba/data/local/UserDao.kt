package com.example.project_ceiba.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.project_ceiba.data.model.PostEntity
import com.example.project_ceiba.data.model.UserEntity

@Dao
interface UserDao {

    @Query("SELECT * FROM UserEntity")
    suspend fun getLocalUserList(): List<UserEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveLocalUserList(userEntity: UserEntity)

    @Query("SELECT * FROM postEntity WHERE PostEntity.userId = :id")
    suspend fun getLocalUserPost(id: Int): List<PostEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveLocalUserPost(postEntity: PostEntity)

}