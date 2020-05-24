package com.mergeadapter.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mergeadapter.R
import com.mergeadapter.base.BaseViewHolder
import kotlinx.android.synthetic.main.header.view.*
import java.lang.IllegalArgumentException

/**
 * Created by Gastón Saillén on 23 May 2020
 */
class HeaderAdapter(private val context:Context, private val headerText:String):RecyclerView.Adapter<BaseViewHolder<*>>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return HeaderViewHolder(LayoutInflater.from(context).inflate(R.layout.header,parent,false))
    }

    override fun getItemCount(): Int {
        return 1
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when(holder){
            is HeaderViewHolder -> holder.bind(headerText,position)
            else -> throw IllegalArgumentException()
        }
    }

    inner class HeaderViewHolder(itemView: View):BaseViewHolder<String>(itemView){
        override fun bind(item: String, position: Int) {
            itemView.header_text.text = item
        }
    }
}