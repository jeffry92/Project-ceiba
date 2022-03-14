package com.example.project_ceiba.domain

import com.example.project_ceiba.data.model.Post
import com.example.project_ceiba.data.model.User
import com.example.project_ceiba.rest.Constants
import retrofit2.http.GET
import retrofit2.http.Query

interface Webservice {

    @GET(Constants.GET_USERS)
    suspend fun getUserList(): List<User>

    @GET(Constants.GET_POST_USER)
    suspend fun getUserPost(@Query("userId")id: Int): List<Post>
}