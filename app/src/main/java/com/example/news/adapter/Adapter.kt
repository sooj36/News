package com.example.news.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.news.R

class Adapter(
    private val context: Context,
    private val list: Array<String>,
) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    interface OnItemClickListener { //list 클릭 시 수행할
        fun onItemClick(article : String)
    }

    private var listener : OnItemClickListener? = null

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val textView : TextView = itemView.findViewById(R.id.news_text_view)

        fun bind(news : String) {
            textView.text = news

            // 아이템 클릭 -> listener 로 클릭된 아이템 (news : String) 전달
            itemView.setOnClickListener {
                listener?.onItemClick(news)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.news_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val news = list[position]
        holder.bind(news)
    }

    override fun getItemCount() = list.size
    }
