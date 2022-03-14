package com.example.project_ceiba.core

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder <T>(itemView: View) : RecyclerView.ViewHolder(itemView){
    abstract fun bind(item: T)
}