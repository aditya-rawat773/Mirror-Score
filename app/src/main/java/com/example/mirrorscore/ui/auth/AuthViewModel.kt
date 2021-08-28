package com.example.mirrorscore.ui.auth


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mirrorscore.repository.AuthRepository


class AuthViewModel:ViewModel() {


   private val auth:AuthRepository = AuthRepository()

    var _login = MutableLiveData<String>()

    fun login(email:String,password:String){
        _login.value =auth.login(email,password).value
        Log.d("xx", "login:${_login.value.toString()} ")
    }


}