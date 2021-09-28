package com.example.mirrorscore.ui.auth

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.mirrorscore.R
import com.example.mirrorscore.api.RetrofitInstance
import com.example.mirrorscore.repository.Repository
import com.example.mirrorscore.utils.Resource
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment() {

    private lateinit var loginViewModel:LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val repository = Repository()
        val viewModelProviderFactory = ViewModelProviderFactory(repository)
        loginViewModel = ViewModelProvider(this,viewModelProviderFactory).get(LoginViewModel::class.java)


        buttonLogin.setOnClickListener {
            val email = editTextTextEmailAddress.text.toString().trim()
            val password = editTextTextPassword.text.toString().trim()

            loginViewModel.getLoginData(email, password)
        }


        loginViewModel.getLoginPostObserver().observe(viewLifecycleOwner,{

            when(it){
                is Resource.Success ->{
                    // hideProgressBar()
                    it.data?.let { response ->

                        val result = response.Result
                        val token = result.token.access
                        RetrofitInstance().getToken(token)
                            Log.d("aditya", "onViewCreated:${token} ")
                            Toast.makeText(requireContext(), "${response.Comments}", Toast.LENGTH_SHORT).show()

                    }
                }
                is Resource.Error ->{
                    // hideProgressBar()
                    it.message?.let{ message ->
                        Toast.makeText(requireContext(), "Invalid Id or Password", Toast.LENGTH_SHORT).show()
                    }
                }
                is Resource.Loading ->{
                    //showProgressBar()
                }
            }
        })



    }

}