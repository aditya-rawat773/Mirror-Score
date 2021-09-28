package com.example.mirrorscore.ui.auth


import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mirrorscore.models.LoginResponse
import com.example.mirrorscore.repository.Repository
import com.example.mirrorscore.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response


class LoginViewModel(
    private val repository: Repository
):ViewModel() {

    private val loginData: MutableLiveData<Resource<LoginResponse>> = MutableLiveData()

    fun getLoginPostObserver(): MutableLiveData<Resource<LoginResponse>> {
        return loginData
    }

    fun getLoginData(email:String,password:String){
        loginData.postValue(Resource.Loading())
        viewModelScope.launch (Dispatchers.IO) {
            val response = repository.postLoginDetail(email,password)
            loginData.postValue(handleLoginResponse(response))
        }
    }

    private fun handleLoginResponse(response: Response<LoginResponse>): Resource<LoginResponse>? {
        return if (response.isSuccessful){
            Resource.Success(response.body()!!)
        } else{
            Resource.Error(response.message())
        }

    }
}