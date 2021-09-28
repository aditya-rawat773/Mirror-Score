package com.example.mirrorscore.ui.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mirrorscore.repository.AuthRepository

class ViewModelProviderFactory(
    private val AuthRepository: AuthRepository
): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return LoginViewModel(AuthRepository) as T
    }
}