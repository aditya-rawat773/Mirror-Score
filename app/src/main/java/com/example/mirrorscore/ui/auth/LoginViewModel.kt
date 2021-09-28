package com.example.mirrorscore.ui.auth


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mirrorscore.models.LoginResponse
import com.example.mirrorscore.repository.AuthRepository
import com.example.mirrorscore.utils.Resource


class LoginViewModel(
    private val AuthRepository: AuthRepository
):ViewModel() {

}