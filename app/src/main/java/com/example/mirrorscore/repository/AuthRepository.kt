package com.example.mirrorscore.repository

import com.example.mirrorscore.network.MirrorScoreApi

class AuthRepository(
    private val api: MirrorScoreApi
):BaseRepository() {

    suspend fun login(
        email: String,
        password: String
    ) = safeApiCall {

        api.login(email,password)
    }
}