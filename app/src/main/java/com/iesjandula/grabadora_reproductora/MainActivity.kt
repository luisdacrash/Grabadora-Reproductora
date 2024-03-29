package com.iesjandula.grabadora_reproductora

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // Variables para almacenar la URL del video y la lista de URLs
    private var videoURL : String? = null
    private lateinit var listaURL : ArrayList<String>
    // Método que se llama cuando se crea la actividad
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Obtiene la URL del video y la lista de URLs del Intent
        videoURL = intent.getStringExtra("VIDEO_URL")
        listaURL = intent.getStringArrayListExtra("LISTA_URL") ?: ArrayList()
    }
    //metodo que muestra el menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }
    //metodo que da funcionalidad al menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.mGrabarVideo -> {
                // Cuando se selecciona "Grabar Video", se crea un Intent para iniciar GrabarVideo
                val intent = Intent(this, GrabarVideo::class.java)

                intent.putExtra("LISTA_URL", listaURL)

                startActivity(intent)
                return true
            }

            R.id.mReproducirVideo -> {

                // Verifica si hay una URI de video y la agrega a la lista si aún no está añadida
                if (!videoURL.isNullOrEmpty() || !listaURL.isEmpty()) {
                    val intent = Intent(this, ReproducirVideo::class.java)

                    if (videoURL != null && !listaURL.contains(videoURL!!)) {
                        // Asegura que el video no esté ya en la lista
                        listaURL.add(videoURL!!)
                    }

                    // Pasa la lista de URIs a través del Intent y inicia la actividad
                    intent.putExtra("LISTA_URL", listaURL)
                    startActivity(intent)
                } else {
                    // Muestra un mensaje si no se ha grabado ningún video
                    Toast.makeText(this, "No se ha grabado ningún video", Toast.LENGTH_SHORT).show()
                }
                return true
            }

            else -> return super.onOptionsItemSelected(item)
        }
    }
}