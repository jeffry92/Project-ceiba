package com.example.project_ceiba.data.remote

import com.example.project_ceiba.data.model.Post
import com.example.project_ceiba.data.model.User
import com.example.project_ceiba.domain.Webservice
import javax.inject.Inject

class UserApiSource @Inject constructor(private val webService: Webservice) {

    suspend fun getUserList(): List<User> = webService.getUserList()

    suspend fun getUserPost(id: Int): List<Post> = webService.getUserPost(id)
}