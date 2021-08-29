package com.example.mirrorscore.ui.auth


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mirrorscore.repository.AuthRepository
import com.example.mirrorscore.responses.LoginResponse


class LoginViewModel:ViewModel() {


   private val auth:AuthRepository = AuthRepository()

    var login:MutableLiveData<String> = MutableLiveData()

    fun login(email:String,password:String){
        login.value =auth.login(email,password).value
    }


}