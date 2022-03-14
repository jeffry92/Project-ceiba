package com.example.project_ceiba.domain

import com.example.project_ceiba.core.InternetChecker
import com.example.project_ceiba.data.local.UserLocalSource
import com.example.project_ceiba.data.model.Post
import com.example.project_ceiba.data.model.User
import com.example.project_ceiba.data.model.toPostEntity
import com.example.project_ceiba.data.model.toUserEntity
import com.example.project_ceiba.data.remote.UserApiSource

class UserRepositoryclas (
    private val userApiSource: UserApiSource,
    private val userLocalSource: UserLocalSource,
    private val internetChecker: InternetChecker

): UserReposity{
    override suspend fun getUserList(): List<User> {
        return if (internetChecker.isNetworkAvailable()){
            if (userLocalSource.getUserList().isNotEmpty()){
                userLocalSource.getUserList()
            }else{
                val result = userApiSource.getUserList()
                result.forEach { user -> userLocalSource.saveUserList(user.toUserEntity())
                }
                result
            }
        }else{
            userLocalSource.getUserList()
        }
    }

    override suspend fun getUserPost(id: Int): List<Post> {
       return if (internetChecker.isNetworkAvailable()){
           if (userLocalSource.getUserPost(id).isNotEmpty()){
               userLocalSource.getUserPost(id)
           }else{
               val result = userApiSource.getUserPost(id)
               result.forEach { post -> userLocalSource.saveUserPost(post.toPostEntity())
               }
               result
           }
       }else{
           userLocalSource.getUserPost(id)
       }
    }

}