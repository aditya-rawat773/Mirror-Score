package com.example.mirrorscore.ui.auth


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mirrorscore.repository.AuthRepository
import com.example.mirrorscore.responses.LoginResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Response


class LoginViewModel:ViewModel() {


   private val auth:AuthRepository = AuthRepository()

    private var loginData:MutableLiveData<LoginResponse> = MutableLiveData()


    fun getLoginObserver(): MutableLiveData<LoginResponse> {
        return loginData
    }

    fun login(email:String,password:String) {

        viewModelScope.launch(Dispatchers.IO) {
            val loginResponse =auth.login(email,password)
           Log.d("adi", "login(ViewModel):${loginResponse.body()!!} ")
                loginData.postValue(loginResponse.body())

        }
    }


}