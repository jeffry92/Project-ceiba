package com.example.project_ceiba.core

import kotlinx.coroutines.coroutineScope
import java.net.InetSocketAddress
import java.net.Socket

class InternetCheckerclas: InternetChecker{

    override suspend fun isNetworkAvailable() = coroutineScope {
        return@coroutineScope try {
            val socket = Socket()
            val socketAddress = InetSocketAddress("8.8.8.8", 53)
            socket.connect(socketAddress,3000)
            socket.close()
            true
        }catch (e: Exception){
            false
        }
    }
}