package com.example.mirrorscore.ui.home

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowId
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mirrorscore.R
import com.example.mirrorscore.responses.Data
import com.example.mirrorscore.responses.PostResponse
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.list_post.*

class HomeFragment : Fragment(),HomeAdapter.onitemClick {



    override fun onItemClicked(position: Int) {
        homeViewModel.upVote(listData[position].postId)
    }

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var mHomeAdapter: HomeAdapter
    private lateinit var listData:ArrayList<Data>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homeViewModel = ViewModelProvider(requireActivity()).get(HomeViewModel::class.java)




        recyclerView.apply {

            mHomeAdapter = HomeAdapter(this@HomeFragment)
            layoutManager = LinearLayoutManager(requireContext())

            adapter = mHomeAdapter
        }

            homeViewModel.getPostObserver().observe(viewLifecycleOwner, {
                Log.d("post", "onViewCreated:$it ")
                if (it != null) {
                    listData = it.Result.data
                    Log.d("ankit", "onViewCreated:${listData.toString()} ")
                    mHomeAdapter.setListData(listData)
                    mHomeAdapter.notifyDataSetChanged()
                } else {
                    Toast.makeText(requireContext(), "Error", Toast.LENGTH_LONG).show()
                }

            })

        homeViewModel.getPostUpVoteObserver().observe(viewLifecycleOwner, {
            Log.d("postUpVote", "onViewCreated: ${it.toString()}")
            mHomeAdapter.notifyDataSetChanged()
        })
        homeViewModel.home()

        floating_action_button.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_addNewPostFragment)

        }

    }

}