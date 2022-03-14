package com.example.project_ceiba.ui.util

import android.app.Activity
import android.app.Dialog
import android.view.LayoutInflater
import com.example.project_ceiba.databinding.CustomLoadingDialogBinding

class CustomLoading(private val activity: Activity) {

    private lateinit var dialog: Dialog
    private lateinit var binding: CustomLoadingDialogBinding

    fun showLoadingDialog(){
        binding = CustomLoadingDialogBinding.inflate(LayoutInflater.from(activity.applicationContext))
        dialog = Dialog(activity)
        dialog.setContentView(binding.root)
        dialog.setCancelable(false)
        dialog.show()
    }

    fun cancelDialog(){
        dialog.dismiss()
    }
}