package com.example.mirrorscore.repository



import com.example.mirrorscore.api.RetrofitInstance
import com.example.mirrorscore.models.LoginResponse
import retrofit2.Response

class Repository{

    suspend fun postLoginDetail(email:String, password:String):Response<LoginResponse>{
        return RetrofitInstance.api.login(email, password)
    }
}
