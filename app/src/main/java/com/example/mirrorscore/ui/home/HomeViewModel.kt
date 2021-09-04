package com.example.mirrorscore.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mirrorscore.repository.Repository
import com.example.mirrorscore.responses.PostResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel:ViewModel() {
    private val postRepository:Repository = Repository()
    private val postData:MutableLiveData<PostResponse> = MutableLiveData()

    fun getPostObserver():MutableLiveData<PostResponse>{
        return postData
    }

    fun home(){
        viewModelScope.launch(Dispatchers.IO) {
            val postResponse = postRepository.post()
            postData.postValue(postResponse.body())
        }
    }

    fun upVote(postId:Int){
        viewModelScope.launch (Dispatchers.IO) {
            postRepository.mPostUpVote(postId)
        }
    }

}