package com.mergeadapter.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mergeadapter.R
import com.mergeadapter.base.BaseViewHolder
import com.mergeadapter.model.User
import kotlinx.android.synthetic.main.main_row.view.*
import java.lang.IllegalArgumentException

/**
 * Created by Gastón Saillén on 23 May 2020
 */
class MainAdapter(val context:Context,val userList:MutableList<User>):
    RecyclerView.Adapter<BaseViewHolder<*>>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return MainAdapterViewHolder(LayoutInflater.from(context).inflate(R.layout.main_row,parent,false))
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when(holder){
            is MainAdapterViewHolder -> holder.bind(userList[position],position)
            else -> throw IllegalArgumentException()
        }
    }

    inner class MainAdapterViewHolder(itemView:View):BaseViewHolder<User>(itemView){
        override fun bind(item: User, position: Int) {
            itemView.username.text = item.name
            Glide.with(context).load(item.image).into(itemView.profile_image)
        }
    }
}