package com.example.mirrorscore.utils

interface AuthListener {
    fun onStarted()
    fun onSuccess()
    fun onFailure(message: String)
}