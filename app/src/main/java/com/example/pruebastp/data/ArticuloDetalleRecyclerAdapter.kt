package com.example.pruebastp.data

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pruebastp.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.img_article.view.*


class ArticuloDetalleRecyclerAdapter :
    RecyclerView.Adapter<ArticuloDetalleRecyclerAdapter.ViewHolder>() {
    var imgDetalles = ArrayList<Pictures>()



    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
val view = LayoutInflater.from(parent.context).inflate(R.layout.img_article,parent,false)
        return ViewHolder(view)

    }

    override fun getItemCount(): Int {
        return imgDetalles.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       Picasso.get()
           .load(imgDetalles[position].secure_url)
           .into(holder.itemView.imageViewProducto)
    }

}