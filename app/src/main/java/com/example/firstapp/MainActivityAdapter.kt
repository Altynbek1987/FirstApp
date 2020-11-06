package com.example.firstapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MainActivityAdapter : RecyclerView.Adapter<MainActivityAdapter.ViewHolder>(){

    private var list = mutableListOf<String>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_holder,parent,false))

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(list[position])
    }

   inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun onBind(s: String) {

        }

    }
}


