package com.example.mirrorscore.ui.addnewpost

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mirrorscore.repository.Repository
import com.example.mirrorscore.models.NewPostResponse

class NewPostViewModel:ViewModel() {

    private val auth: Repository = Repository()
    private val newPostData:MutableLiveData<NewPostResponse> = MutableLiveData()

    fun getPostObserver():MutableLiveData<NewPostResponse>{
        return newPostData
    }

    fun mNewPost(subjectId:Int,text:String){
//        viewModelScope.launch(Dispatchers.IO) {
//            val newPostResponse = auth.postNew(subjectId, text)
//            if(newPostResponse.isSuccessful){
//                newPostData.postValue(newPostResponse.body()!!)
//            }
//        }
    }

}