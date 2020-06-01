package com.example.pruebastp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.example.pruebastp.data.Article
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.list_item_articulo.view.*

class AdaptadorDeArticulos : RecyclerView.Adapter<AdaptadorDeArticulos.ViewHolder>() {

    class ViewHolder(view: View): RecyclerView.ViewHolder(view)
var articulos = ArrayList<Article>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.list_item_articulo,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return articulos.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    var articulo = articulos[position]
        holder.itemView.textViewTitulo.text = articulo.title
        holder.itemView.textViewDesc.text = articulo.descripcion

        Picasso.get()
            .load(articulo.pictures[position].secure_url)
            .into(holder.itemView.imgArticulo)

    }

}