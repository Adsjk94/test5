package com.madhram.list

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item.view.*

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val title: TextView = itemView.row_tv_title
    private val image: ImageView= itemView.row_img

    fun bind(companies: Companies) {
        title.text = companies.title
        Picasso.with(itemView.context)
            .load(companies.linkImage)
            .into(image)

    }

}