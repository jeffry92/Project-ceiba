package com.example.project_ceiba.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import com.example.project_ceiba.core.Result
import com.example.project_ceiba.data.model.User
import com.example.project_ceiba.databinding.ActivityMainBinding
import com.example.project_ceiba.presentation.UserViewModel
import com.example.project_ceiba.rest.Constants
import com.example.project_ceiba.ui.adapter.ActivityAdapter
import com.example.project_ceiba.ui.adapter.OnClickListenerView
import com.example.project_ceiba.ui.util.CustomLoading
import com.example.project_ceiba.ui.util.PostActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), OnClickListenerView {

    private lateinit var binding: ActivityMainBinding
    private val userViewModel: UserViewModel by viewModels()
    private lateinit var customLoading: CustomLoading
    private lateinit var adapter: ActivityAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        adapter = ActivityAdapter(mutableListOf(),this)
        customLoading = CustomLoading(this)

        observer()
        userFilter()
    }

    private fun observer() {
        userViewModel.getUserList().observe(this){ result ->
            when(result){
                is Result.Loading ->{
                    customLoading.showLoadingDialog()
                }
                is Result.Success ->{
                    customLoading.cancelDialog()
                    adapter = ActivityAdapter(result.data.toMutableList(),this)
                    binding.recyclerViewSearchResults.adapter = adapter
                }
                is Result.Failed ->{
                    customLoading.cancelDialog()
                    Toast.makeText(applicationContext,"Error: ${result.exception}",Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    private fun userFilter() {
        binding.editTextSearch.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
               //"Not yet implemented"
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                //"Not yet implemented"
            }

            override fun afterTextChanged(s: Editable?) {
               val count = adapter.userFilter(s.toString())
                if (count.isEmpty())
                    binding.emptyView.root.visibility = View.VISIBLE
                else
                    binding.emptyView.root.visibility = View.INVISIBLE
            }

        })
    }

    override fun onClick(userItem: User) {
        startActivity(Intent(this, PostActivity::class.java).putExtra(Constants.INTENT_KET,userItem))
    }
}