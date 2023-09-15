package com.example.news

import android.content.Context
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter(
    private val context: Context,
    private val list: Array<String>,
) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(article : String)
    }

    private var listener : OnItemClickListener? = null

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val textView : TextView = itemView.findViewById(R.id///프래그먼트 만들고 올것)
    }
}