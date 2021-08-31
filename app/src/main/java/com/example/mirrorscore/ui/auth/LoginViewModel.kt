package com.example.mirrorscore.ui.auth


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mirrorscore.repository.Repository
import com.example.mirrorscore.responses.LoginResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class LoginViewModel:ViewModel() {


   private val auth:Repository = Repository()

    private var loginData:MutableLiveData<LoginResponse> = MutableLiveData()

    fun getLoginObserver(): MutableLiveData<LoginResponse> {
        return loginData
    }

    fun login(email:String,password:String) {

        viewModelScope.launch(Dispatchers.IO) {
            val loginResponse =auth.login(email,password)
         //  Log.d("adi", "login(ViewModel):${loginResponse.body()!!} ")

            if(loginResponse.isSuccessful) {
                loginData.postValue(loginResponse.body()!!)
            }


        }
    }


}