package com.example.mirrorscore.ui.addnewpost

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mirrorscore.R
import com.example.mirrorscore.ui.home.HomeAdapter
import kotlinx.android.synthetic.main.fragment_add_new_post.*
import kotlinx.android.synthetic.main.fragment_home.*


class AddNewPostFragment : Fragment() {

    lateinit var viewModel: NewPostViewModel

    companion object{
        const val IMAGE_REQUEST_CODE = 100
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_new_post, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(requireActivity()).get(NewPostViewModel::class.java)

        btn_publish.setOnClickListener {
            val text = add_text.text.toString().trim()
            val subjectId = 1
            viewModel.getPostObserver().observe(viewLifecycleOwner, {
                if (it.ReponseMessage == "SUCCESS") {
                    findNavController().navigate(R.id.action_addNewPostFragment_to_homeFragment)
                    Toast.makeText(requireContext(), "${it.Comments.toString()}", Toast.LENGTH_SHORT).show()
                    
                }
            })

            viewModel.mNewPost(subjectId, text)

        }



        btn_add_image.setOnClickListener{

            val getIntent = Intent(Intent.ACTION_GET_CONTENT)
            getIntent.type = "image/*"

            val pickIntent =
                Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            pickIntent.type = "image/*"

            val chooserIntent = Intent.createChooser(getIntent, "Select Image")
            chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, arrayOf(pickIntent))

            startActivityForResult(chooserIntent, IMAGE_REQUEST_CODE)

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == IMAGE_REQUEST_CODE && resultCode == RESULT_OK){
            iv_image.setImageURI(data?.data)
        }
        Log.d("url", "onActivityResult: ${data?.data}")
    }
    
}