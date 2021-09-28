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

class HomeAdapter(val clickListener: HomeFragment):RecyclerView.Adapter<HomeAdapter.MyViewHolder>() {



    var items = ArrayList<Data>()


    fun setListData(data: ArrayList<Data>){
        this.items = data
        Log.d("ankit", "setListData:${data} ")
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeAdapter.MyViewHolder {

        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.list_post,parent,false)
        return MyViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: HomeAdapter.MyViewHolder, position: Int) {
        holder.bind(items[position],position)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    interface onitemClick{
        fun onItemClicked(position: Int)
    }

   inner class MyViewHolder(view:View):RecyclerView.ViewHolder(view) {
       private val tvName = view.tv_name
       private val tvSubject = view.tv_subject
       private val tvTime = view.tv_time
       private val tvUpVote = view.tv_upvote
       private val tvText = view.tv_text

       @SuppressLint("SetTextI18n")
       fun bind(data: Data,position: Int){

           tvText.text = data.text
           tvName.text = data.userName
           tvSubject.text = data.subject
           tvTime.text = data.updatedOn
           tvUpVote.text = "UpVote Post ("+data.upvoteCount.toString()+")"

           with(itemView){
               this.tv_upvote

               this.tv_upvote.setOnClickListener{
                   Log.d("like", "bind:${data.postId} ")
                   clickListener.onItemClicked(position)

               }
           }
       }
    }

}


