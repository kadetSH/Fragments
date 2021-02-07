package com.example.fragments.recyclerMy

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fragments.R

class FilmsAdapter(private val layoutInflater: LayoutInflater,
                   private val items: List<FilmsItem>,
                   private val listener: ((newsItem: FilmsItem, position: Int, note : String) -> Unit)?) : RecyclerView.Adapter<FilmsViewHolder>() {

//    val nameFilm = findViewById<TextView>(R.id.nameFilm)
//    val imageFilm = view.findViewById<ImageView>(R.id.imageFilmId)
//    val shortDescription = view.findViewById<TextView>(R.id.shortDescription)
//    val description = view.findViewById<Button>(R.id.description)
//    val share = view.findViewById<Button>(R.id.share)
//    var star = view.findViewById<ImageView>(R.id.idStar)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmsViewHolder {
        return FilmsViewHolder(layoutInflater.inflate(R.layout.template, parent, false))
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: FilmsViewHolder, position: Int) {
        holder.bind(items[position])

//        holder.itemView.setOnClickListener {
//            listener?.invoke(items[position])
//        }

        holder.star.setOnClickListener {
            listener?.invoke(items[position], position, "star")
        }

        holder.description.setOnClickListener {
            listener?.invoke(items[position], position, "description")
        }
    }
}