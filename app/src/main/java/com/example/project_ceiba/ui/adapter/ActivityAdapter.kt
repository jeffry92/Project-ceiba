package com.example.project_ceiba.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.project_ceiba.core.BaseViewHolder
import com.example.project_ceiba.data.model.User
import com.example.project_ceiba.databinding.UserListItemBinding

class ActivityAdapter (
    private val userList: MutableList<User>,
    private val onClickListener: OnClickListenerView,
    private var userLisTemp: List<User> = userList.toList()

): RecyclerView.Adapter<BaseViewHolder<*>>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val itemBinding = UserListItemBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return MainActivityBaseView(itemBinding)
    }

    override fun onBindViewHolder(holderBase: BaseViewHolder<*>, position: Int) {
       when(holderBase){
           is MainActivityBaseView -> holderBase.bind(userList[position])
       }

    }

    override fun getItemCount(): Int = userList.size

    fun userFilter(filterText: String): List<User>{
        if (filterText.isEmpty()) return userList
        userList.clear()
        for (user in userLisTemp){
            if (user.name!!.lowercase().contains(filterText.lowercase())){
                userList.add(user)
            }
        }
        notifyDataSetChanged()
        return userList
    }

    private inner class MainActivityBaseView(
        val binding: UserListItemBinding
    ): BaseViewHolder<User>(binding.root){
        override fun bind(item: User) {
            binding.name.text = item.name
            binding.phone.text = item.phone
            binding.email.text = item.email
            binding.btnViewPost.setOnClickListener { onClickListener.onClick(item) }
        }

    }
}