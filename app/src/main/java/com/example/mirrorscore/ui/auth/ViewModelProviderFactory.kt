package com.example.mirrorscore.ui.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mirrorscore.repository.Repository

class ViewModelProviderFactory(
    private val Repository: Repository
): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return LoginViewModel(Repository) as T
    }
}