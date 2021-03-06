package com.example.fragments.recyclerMy

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.fragments.R
import kotlinx.android.synthetic.main.template.view.*

class FilmsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {



    val colorTrue = ContextCompat.getColor(itemView.context, R.color.starTrue)
    val colorFalse = ContextCompat.getColor(itemView.context, R.color.starFalse)
    var star = itemView.idStar
    var description = itemView.description
    fun bind(item: FilmsItem) {

        (itemView.nameFilm as TextView).text = item.nameFilm
        (itemView.shortDescription as TextView).text = item.shortDescription
        (itemView.imageFilmId as ImageView).setImageResource(item.imageFilm)
        star.isSelected = item.star

        if (star.isSelected == true){
//            var starAnim = android.view.animation.AnimationUtils.loadAnimation(context, R.anim.scale_star)
//            star.startAnimation(starAnim)
            star.setBackgroundColor(colorTrue)
        }else star.setBackgroundColor(colorFalse)

    }

}