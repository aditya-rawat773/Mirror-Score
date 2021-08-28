package com.example.mirrorscore.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mirrorscore.network.MirrorScoreService
import com.example.mirrorscore.responses.LoginResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.math.log

class AuthRepository{

     fun login(email:String, password:String):LiveData<String>{

        val loginResponse = MutableLiveData<String>()

         MirrorScoreService().login(email,password)

             .enqueue(object : Callback<LoginResponse> {
                 override fun onResponse(
                     call: Call<LoginResponse>,
                     response: Response<LoginResponse>
                 ) {
                     Log.d("ar", "onResponse:${response} ")
                     if (response.isSuccessful) {
                         loginResponse.value = response.body()?.toString()
                     } else {
                         loginResponse.value = response.errorBody()?.toString()
                     }
                 }

                 override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                     loginResponse.value = t.message
                 }
             })
         return loginResponse
    }

}
