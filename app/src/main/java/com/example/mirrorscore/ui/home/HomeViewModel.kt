package com.example.mirrorscore.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mirrorscore.repository.Repository
import com.example.mirrorscore.models.PostResponse
import com.example.mirrorscore.models.PostUpVoteResponse

class HomeViewModel:ViewModel() {
    private val postRepository:Repository = Repository()
    private val postData:MutableLiveData<PostResponse> = MutableLiveData()
    private val postUpVoteData:MutableLiveData<PostUpVoteResponse> = MutableLiveData()

    fun getPostObserver():MutableLiveData<PostResponse>{
        return postData
    }

    fun getPostUpVoteObserver():MutableLiveData<PostUpVoteResponse>{
        return postUpVoteData
    }

    fun home(){
//        viewModelScope.launch(Dispatchers.IO) {
////            val postResponse = postRepository.post()
//            postData.postValue(postResponse.body())
//        }
    }

    fun upVote(postId:Int){
//        viewModelScope.launch (Dispatchers.IO) {
//            val response =postRepository.mPostUpVote(postId)
//            if(response.isSuccessful) {
//                Log.d("vivek", "upVote: ${response.body()}")
//                postUpVoteData.postValue(response.body())
//            }
//        }
    }

}