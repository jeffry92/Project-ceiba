package com.example.project_ceiba.core

interface InternetChecker {

    suspend fun isNetworkAvailable(): Boolean
}