package com.iesjandula.grabadora_reproductora

import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView

class VideoViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
    val botonReproducir : Button = itemView.findViewById(R.id.botonReproducir)
}