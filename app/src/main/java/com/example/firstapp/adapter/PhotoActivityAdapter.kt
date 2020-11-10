package com.example.firstapp.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.firstapp.R
import com.example.firstapp.extensions.loadImage
import com.example.firstapp.interf.OnItemClickListener
import kotlinx.android.synthetic.main.list_holder.view.*

class PhotoActivityAdapter(private var listUrl: MutableList<String>,  var onItemClickListener: OnItemClickListener) : RecyclerView.Adapter<PhotoActivityAdapter.ViewHolder>(){
    //var position: Int? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_holder,parent,false))

    override fun getItemCount(): Int {
        return listUrl.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       // this.position = position
        holder.onBind(listUrl[position])
    }

    fun add(list: String) {
        listUrl.add(list)
        notifyDataSetChanged()
    }


   inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        fun onBind(image: String) {

            itemView.image_holder.loadImage(image,
                R.drawable.ic_launcher_background
            )
            itemView.image_holder.setOnClickListener {
                onItemClickListener.itemClick(adapterPosition)
            }

        }

    }
}


