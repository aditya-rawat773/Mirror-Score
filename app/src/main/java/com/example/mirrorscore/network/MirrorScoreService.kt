package com.example.mirrorscore.network

import android.util.Log
import com.example.mirrorscore.responses.LoginResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

const val BASE_URL="https://mirrorscore-android.herokuapp.com/"
interface MirrorScoreService {

    @FormUrlEncoded
    @POST("login")
     fun login(
        @Field("email") email:String,
        @Field("password") password:String
    ): Call<LoginResponse>

     companion object{
         operator fun invoke():MirrorScoreService{
             return Retrofit.Builder()
                 .baseUrl(BASE_URL)
                 .addConverterFactory(GsonConverterFactory.create())
                 .build()
                 .create(MirrorScoreService::class.java)
         }
     }
}



