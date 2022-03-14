package com.example.project_ceiba.data.local

import com.example.project_ceiba.data.model.*

class UserLocalSourceclas(private val userDao: UserDao): UserLocalSource {

    override suspend fun getUserList(): List<User> {
        return userDao.getLocalUserList().toUserList()
    }

    override suspend fun saveUserList(user: UserEntity) {
       userDao.saveLocalUserList(user)
    }

    override suspend fun getUserPost(id: Int): List<Post> {
        return userDao.getLocalUserPost(id).toPostList()
    }

    override suspend fun saveUserPost(user: PostEntity) {
        userDao.saveLocalUserPost(user)
    }

}