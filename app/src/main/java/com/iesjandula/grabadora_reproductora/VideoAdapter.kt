package com.iesjandula.grabadora_reproductora

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView

class VideoAdapter (private val context: Context, private val listaUrl: ArrayList<Uri>) : RecyclerView.Adapter<VideoAdapter.VideoViewHolder>() {

        // ViewHolder para representar cada elemento de la lista
        class VideoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val playButton: Button = itemView.findViewById(R.id.botonReproducir)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.cardview,parent,false)
        return VideoViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return listaUrl.size
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        val url = listaUrl [position]
        holder.playButton.setOnClickListener {
            val intentPantallaCompleta = Intent(context,PantallaCompleta::class.java)
            intentPantallaCompleta.putExtra("VIDEO_URL",url.toString())
            context.startActivity(intentPantallaCompleta)
        }
    }
}