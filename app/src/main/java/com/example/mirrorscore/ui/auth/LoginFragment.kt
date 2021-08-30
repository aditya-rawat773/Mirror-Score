package com.example.mirrorscore.ui.auth

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.mirrorscore.R
import com.example.mirrorscore.responses.LoginResponse
import com.example.mirrorscore.utils.Utils
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment() {

    private lateinit var viewModel:LoginViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(requireActivity()).get(LoginViewModel::class.java)




        buttonLogin.setOnClickListener {
            val email = editTextTextEmailAddress.text.toString().trim()
            val password = editTextTextPassword.text.toString().trim()

            viewModel.login(email, password)

            viewModel.login1.observe(viewLifecycleOwner, {

                Log.d("adi", "onViewCreated:$it ")
                var res = 
                Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
            })
        }



    }

}