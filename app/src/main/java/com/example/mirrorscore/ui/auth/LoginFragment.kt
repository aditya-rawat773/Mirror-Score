package com.example.mirrorscore.ui.auth

import android.content.Context
import android.content.SharedPreferences
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
import com.example.mirrorscore.responses.LoginResponse
import com.example.mirrorscore.utils.Utils
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment() {

    private lateinit var viewModel:LoginViewModel
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(requireActivity()).get(LoginViewModel::class.java)

        sharedPreferences = requireActivity().getSharedPreferences("SHARED_PREF",Context.MODE_PRIVATE)



        buttonLogin.setOnClickListener {
            val email = editTextTextEmailAddress.text.toString().trim()
            val password = editTextTextPassword.text.toString().trim()

            viewModel.getLoginObserver().observe(viewLifecycleOwner, { response ->
                //Log.d("adi1", "onViewCreated:$response ")

                if (response.ReponseMessage == "SUCCESS") {
                    Toast.makeText(requireContext(), response.Comments, Toast.LENGTH_SHORT).show()
                   // Log.d("token", "onViewCreated: ${response.Result.token}")


                    val token = response.Result.token.toString()
                    val editor: SharedPreferences.Editor = sharedPreferences.edit()
                    editor.putString("Bearer", token)
                    editor.apply()


                    findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
                } else {
                    Toast.makeText(requireContext(), "Invalid id or password", Toast.LENGTH_SHORT).show()
                }
            })
            viewModel.login(email, password)
        }
    }

}