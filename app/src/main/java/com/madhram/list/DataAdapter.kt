package com.madhram.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.madhram.test.R

class DataAdapter: RecyclerView.Adapter<ViewHolder>() {

    private val listCompanies = mutableListOf<Companies>()

    override fun onCreateViewHolder(parent: ViewGroup, pos: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, pos: Int) {
        holder.bind(listCompanies[pos])
    }

    override fun getItemCount(): Int = listCompanies.size

    fun set(list: MutableList<Companies>) {
        this.listCompanies.clear()
        this.listCompanies.addAll(list)
        notifyDataSetChanged()
    }

}