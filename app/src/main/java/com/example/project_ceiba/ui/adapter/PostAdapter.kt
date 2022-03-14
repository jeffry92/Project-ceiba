package com.example.project_ceiba.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.project_ceiba.core.BaseViewHolder
import com.example.project_ceiba.data.model.Post
import com.example.project_ceiba.databinding.PostListItemBinding

class PostAdapter (
    private val postList: List<Post>

): RecyclerView.Adapter<BaseViewHolder<*>>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val itemBinding = PostListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PosActivityBaseView(itemBinding)
    }

    override fun onBindViewHolder(holderBase: BaseViewHolder<*>, position: Int) {
        when(holderBase){
            is PosActivityBaseView -> holderBase.bind(postList[position])
        }
    }

    override fun getItemCount(): Int = postList.size

    private inner class PosActivityBaseView(
        private val binding: PostListItemBinding

    ): BaseViewHolder<Post>(binding.root){
        override fun bind(item: Post){
            binding.title.text = item.title
            binding.body.text = item.body
        }
    }

}