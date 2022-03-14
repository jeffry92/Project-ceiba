package com.example.project_ceiba.presentation

import androidx.lifecycle.*
import com.example.project_ceiba.core.Result
import com.example.project_ceiba.domain.UserReposity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor (private val reposity: UserReposity): ViewModel() {

    fun getUserList() = liveData(Dispatchers.IO) {
        emit(Result.Loading())
        try {
            emit(Result.Success(reposity.getUserList()))
        }catch (e: Exception){
            emit(Result.Failed(e))
        }
    }
    

    fun getUserPost(id: Int) = liveData(Dispatchers.IO) {
        emit(Result.Loading())
        try {
            emit(Result.Success(reposity.getUserPost(id)))
        }catch (e: Exception){
            emit(Result.Failed(e))
        }
    }
}