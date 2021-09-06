package com.example.mirrorscore.repository

import com.example.mirrorscore.network.MirrorScoreService
import com.example.mirrorscore.responses.LoginResponse
import com.example.mirrorscore.responses.PostResponse
import com.example.mirrorscore.responses.PostUpVoteResponse
import retrofit2.Response

class Repository{

    suspend fun login(email:String, password:String):Response<LoginResponse>{
        // Log.d("adi", "login: ${response.body().toString()}")
        return MirrorScoreService().login(email, password)
    }


    suspend fun post():Response<PostResponse>{
        return MirrorScoreService().getPost()
    }

    suspend fun mPostUpVote(postId:Int):Response<PostUpVoteResponse>{
        return MirrorScoreService().postUpVote(postId)
    }


}
