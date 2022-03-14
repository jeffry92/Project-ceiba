package com.example.project_ceiba.data.local

import com.example.project_ceiba.data.model.Post
import com.example.project_ceiba.data.model.PostEntity
import com.example.project_ceiba.data.model.User
import com.example.project_ceiba.data.model.UserEntity


interface UserLocalSource {

    suspend fun getUserList(): List<User>
    suspend fun saveUserList(user: UserEntity)
    suspend fun getUserPost(id: Int): List<Post>
    suspend fun saveUserPost(user: PostEntity)

}