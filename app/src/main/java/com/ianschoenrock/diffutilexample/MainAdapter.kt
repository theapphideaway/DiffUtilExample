package com.ianschoenrock.diffutilexample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class MainAdapter : ListAdapter<String, MainAdapter.ItemViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.ItemViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ItemViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: MainAdapter.ItemViewHolder, position: Int) {
        holder.setData(getItem(position))
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<String>() {
            override fun areItemsTheSame(
                oldItem: String,
                newItem: String
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: String,
                newItem: String
            ): Boolean {
                return oldItem == newItem
            }
        }
    }

    inner class ItemViewHolder(val view: View): RecyclerView.ViewHolder(view){
        fun setData(title: String){
            val titleTV = view.findViewById<TextView>(R.id.title_tv)
            titleTV.text = title
        }

    }
}