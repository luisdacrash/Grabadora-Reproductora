package com.iesjandula.grabadora_reproductora

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity

class GrabarVideo : AppCompatActivity() {
   private val REQUEST_VIDEO_CAPTURE = 1

override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_grabar_video)

    // Inicia la captura de video
    dispatchTakeVideoIntent()
}

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.volver, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.mVolver -> {
                val intentVolver = Intent(this, MainActivity::class.java)
                startActivity(intentVolver)
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }
    private fun dispatchTakeVideoIntent() {
        Intent(MediaStore.ACTION_VIDEO_CAPTURE).also { takeVideoIntent ->
            takeVideoIntent.resolveActivity(packageManager)?.also {
                startActivityForResult(takeVideoIntent, REQUEST_VIDEO_CAPTURE)
            }
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, datos: Intent?) {
        super.onActivityResult(requestCode, resultCode, datos)

        if (requestCode == REQUEST_VIDEO_CAPTURE && resultCode == RESULT_OK) {
            // Obtiene la URL del video grabado
            val videoUrl: Uri? = datos?.data
            videoUrl?.let {
                // Obtiene datos del Intent que inició esta actividad
                val listUrl: ArrayList<String> =
                    intent.getStringArrayListExtra("LISTA_URL") ?: ArrayList()

                if (!listUrl.contains(it.toString())) {
                    // Asegura que el video no esté ya en la lista
                    listUrl.add(it.toString())
                }

                // Prepara el Intent para pasar datos de vuelta a MainActivity
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("VIDEO_URL", it.toString())
                intent.putExtra("LISTA_URL", listUrl)
                startActivity(intent)
            }
        }
    }
}