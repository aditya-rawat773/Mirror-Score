package com.example.mirrorscore.network


import android.content.SharedPreferences
import com.example.mirrorscore.responses.LoginResponse
import com.example.mirrorscore.responses.NewPostResponse
import com.example.mirrorscore.responses.PostResponse
import com.example.mirrorscore.responses.PostUpVoteResponse
import com.example.mirrorscore.utils.Utils.BASE_URL
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*


interface MirrorScoreService {


    @FormUrlEncoded
    @POST("login")
     suspend fun login(
        @Field("email") email:String,
        @Field("password") password:String
    ): Response<LoginResponse>


     @Headers("Authorization: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ0b2tlbl90eXBlIjoiYWNjZXNzIiwiZXhwIjoxNjMxNjQ4MzY3LCJqdGkiOiJhYzc0NDU1MGEyNzk0OWY1Yjg5NzM3NjFlNmQyNDg1ZSIsInVzZXJfaWQiOjF9.SVRywMggBgS4zEfi34i8uLXigSz-lnwQ6II0fCpakbg")
     @GET("discussionWall/post")
     suspend fun getPost():Response<PostResponse>


     @FormUrlEncoded
     @Headers("Authorization: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ0b2tlbl90eXBlIjoiYWNjZXNzIiwiZXhwIjoxNjMxMDE4ODM5LCJqdGkiOiJlOTkzOTZkNDI3YmE0MGE4OGFiOWJlODY3MzI0ZTRjOSIsInVzZXJfaWQiOjF9.lfMfskPao7oZGf54O3gj2Xzxc2P2WJD2TWHgZvrjFLo")
     @POST("discussionWall/postupvote")
     suspend fun postUpVote(
             @Field("postId") postId:Int
     ):Response<PostUpVoteResponse>

    @FormUrlEncoded
    @Headers("Authorization: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ0b2tlbl90eXBlIjoiYWNjZXNzIiwiZXhwIjoxNjMxMDE4ODM5LCJqdGkiOiJlOTkzOTZkNDI3YmE0MGE4OGFiOWJlODY3MzI0ZTRjOSIsInVzZXJfaWQiOjF9.lfMfskPao7oZGf54O3gj2Xzxc2P2WJD2TWHgZvrjFLo")
    @POST("discussionWall/post")
    suspend fun postNew(
        @Field("subjectId") subjectId:Int,
        @Field("text") text:String,
    ):Response<NewPostResponse>

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



