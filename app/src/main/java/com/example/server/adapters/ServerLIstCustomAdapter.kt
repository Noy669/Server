package com.example.server.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.server.R
import com.example.server.model.Article

class ServerListCustomAdapter(var serverList: ArrayList<Article>) :
    RecyclerView.Adapter<ServerListCustomAdapter.ServerListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServerListViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.fragment_item, parent, false)
        return ServerListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ServerListViewHolder, position: Int) {
        val serverList = serverList[position]
        holder.apply {
            Glide.with(itemView).load(serverList.urlToImage).into(image)
            title.text = serverList.title
            publishInfo.text = serverList.publishedAt
                .replace('T', ' ')
                .replace('Z', ' ')
        }
    }

    override fun getItemCount(): Int {

        return serverList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(itemList: ArrayList<Article>?) {
        itemList?.let {
            this.serverList = itemList
            notifyDataSetChanged()
        }
    }

    class ServerListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image: AppCompatImageView
        var title: AppCompatTextView
        var publishInfo: AppCompatTextView


        init {
            image = itemView.findViewById(R.id.image_view)
            title = itemView.findViewById(R.id.title)
            publishInfo = itemView.findViewById(R.id.dataPublish)

        }
    }
}