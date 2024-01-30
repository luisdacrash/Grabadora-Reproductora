package com.iesjandula.grabadora_reproductora

import android.net.Uri
import android.os.Bundle
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity

class PantallaCompleta : AppCompatActivity() {
    //variable para videoview
    private lateinit var videoView: VideoView
    // Método que se llama cuando se crea la actividad
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla_completa)
        // Obtiene el VideoView del layout
        videoView = findViewById(R.id.videoPantalla)

        // Obtiene la URL del video del Intent
        val videoUrlString = intent.getStringExtra("VIDEO_URL")

        // Si la URL del video no está vacía, reproduce el video
        if (!videoUrlString.isNullOrEmpty()){
            val url = Uri.parse(videoUrlString)
            videoView.setVideoURI(url)
            videoView.start()

            // Cuando el video termina, finaliza la actividad
            videoView.setOnCompletionListener {
                finish()
            }
        }

    }
}