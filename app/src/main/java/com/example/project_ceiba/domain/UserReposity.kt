package com.example.project_ceiba.domain

import com.example.project_ceiba.data.model.Post
import com.example.project_ceiba.data.model.User

interface UserReposity {

    suspend fun getUserList(): List<User>
    suspend fun getUserPost(int: Int): List<Post>
}