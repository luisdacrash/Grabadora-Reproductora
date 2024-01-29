package com.iesjandula.grabadora_reproductora

import android.net.Uri
import android.os.Bundle
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity

class PantallaCompleta : AppCompatActivity() {
    private lateinit var videoView: VideoView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla_completa)

        videoView = findViewById(R.id.videoPantalla)
        val videoUrlString = intent.getStringExtra("VIDEO_URL")

        if (!videoUrlString.isNullOrEmpty()){
            val url = Uri.parse(videoUrlString)
            videoView.setVideoURI(url)
            videoView.start()
            videoView.setOnCompletionListener {
                finish()
            }
        }

    }
}