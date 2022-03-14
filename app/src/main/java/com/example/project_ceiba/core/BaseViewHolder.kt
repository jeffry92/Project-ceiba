package com.example.project_ceiba.core

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class ViewHolder <T>(itemView: View) : RecyclerView.ViewHolder(itemView){
    abstract fun bind(item: T)
}