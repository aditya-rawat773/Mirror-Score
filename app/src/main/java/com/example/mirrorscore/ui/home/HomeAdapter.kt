package com.example.mirrorscore.ui.home

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mirrorscore.R
import com.example.mirrorscore.responses.Data
import kotlinx.android.synthetic.main.list_post.view.*

class HomeAdapter:RecyclerView.Adapter<HomeAdapter.MyViewHolder>() {

    var items = ArrayList<Data>()

    fun setListData(data: ArrayList<Data>){
        this.items = data
        Log.d("ankit", "setListData:${data.toString()} ")
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeAdapter.MyViewHolder {

        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.list_post,parent,false)
        return MyViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: HomeAdapter.MyViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

   inner class MyViewHolder(view:View):RecyclerView.ViewHolder(view) {
       private val tvName = view.tv_name
       private val tvSubject = view.tv_subject
       private val tvTime = view.tv_time
       private val tvUpVote = view.tv_upvote

       @SuppressLint("SetTextI18n")
       fun bind(data:Data){

           tvName.text = data.userName
           tvSubject.text = data.subject
           tvTime.text = data.updatedOn
           tvUpVote.text = data.upvoteCount.toString()

       }
    }
}