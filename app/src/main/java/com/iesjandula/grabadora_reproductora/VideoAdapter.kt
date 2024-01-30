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
            // Botón de reproducción para cada elemento de la lista
            val playButton: Button = itemView.findViewById(R.id.botonReproducir)
        }

    // Método para crear un nuevo ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        // Inflar la vista de cada elemento de la lista
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.cardview,parent,false)

        // Devolver una nueva instancia de VideoViewHolder
        return VideoViewHolder(itemView)
    }

    // Método para obtener el número de elementos en la lista
    override fun getItemCount(): Int {
        // Devolver el tamaño de la lista de URLs
        return listaUrl.size
    }

    // Método para vincular los datos con el ViewHolder
    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        // Obtener la URL del elemento actual
        val url = listaUrl [position]

        // Establecer un OnClickListener para el botón de reproducción
        holder.playButton.setOnClickListener {
            // Crear un nuevo Intent para iniciar la actividad PantallaCompleta
            val intentPantallaCompleta = Intent(context,PantallaCompleta::class.java)

            // Pasar la URL del video a la actividad PantallaCompleta
            intentPantallaCompleta.putExtra("VIDEO_URL",url.toString())

            // Iniciar la actividad PantallaCompleta
            context.startActivity(intentPantallaCompleta)
        }
    }
}