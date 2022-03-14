package com.example.project_ceiba.ui.util

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.project_ceiba.core.Result
import com.example.project_ceiba.data.model.User
import com.example.project_ceiba.databinding.ActivityPostBinding
import com.example.project_ceiba.presentation.UserViewModel
import com.example.project_ceiba.rest.Constants
import com.example.project_ceiba.ui.adapter.PostAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PostActivity: AppCompatActivity() {

    private lateinit var binding: ActivityPostBinding
    private val userViewModel: UserViewModel by viewModels()
    private lateinit var itemUser: User
    private lateinit var customLoading: CustomLoading

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = ActivityPostBinding.inflate(layoutInflater)
        setContentView(binding.root)
        customLoading = CustomLoading(this)

        initData()
        observer()
    }

    private fun initData() {
        intent.getParcelableExtra<User>(Constants.INTENT_KET)?.let {
            itemUser = it
            binding.name.text = it.name
            binding.phone.text = it.phone
            binding.email.text = it.email
        }
    }

    private fun observer() {
        itemUser.id?.let {
            userViewModel.getUserPost(it).observe(this) { result ->
                when (result) {
                    is Result.Loading -> {
                        customLoading.showLoadingDialog()
                    }
                    is Result.Success -> {
                        customLoading.cancelDialog()
                        binding.recyclerViewPostsResults.adapter = PostAdapter(result.data)
                    }
                    is Result.Failed -> {
                        customLoading.cancelDialog()
                        Toast.makeText(
                            applicationContext,
                            "Error: ${result.exception}",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }
    }
}