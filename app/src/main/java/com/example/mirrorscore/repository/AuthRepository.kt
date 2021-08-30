package com.example.mirrorscore.repository

import com.example.mirrorscore.network.MirrorScoreService
import com.example.mirrorscore.responses.LoginResponse
import retrofit2.Response

class AuthRepository{



    suspend fun login(email:String, password:String):Response<LoginResponse>{
        // Log.d("adi", "login: ${response.body().toString()}")
        return MirrorScoreService().login(email, password)
    }

}
