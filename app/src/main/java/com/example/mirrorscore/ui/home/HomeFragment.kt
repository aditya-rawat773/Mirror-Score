package com.example.mirrorscore.ui.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mirrorscore.R
import com.example.mirrorscore.responses.Data
import com.example.mirrorscore.responses.PostResponse
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {


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
            layoutManager = LinearLayoutManager(requireContext())
            mHomeAdapter = HomeAdapter()
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
        homeViewModel.home()
    }


}