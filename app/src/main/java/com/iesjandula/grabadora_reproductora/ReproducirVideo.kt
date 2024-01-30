package com.iesjandula.grabadora_reproductora

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ReproducirVideo : AppCompatActivity() {

    // Variable para almacenar la lista de URLs en formato String
    lateinit var listaString : ArrayList<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reproducir_video)

        // Obtiene el RecyclerView y la lista de URLs del Intent
        val recyclerView : RecyclerView = findViewById(R.id.recicloso)
        val listaUrl : ArrayList<Uri> = conversionUrl()

        // Configura el RecyclerView con un LinearLayoutManager y un VideoAdapter
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        val adapter = VideoAdapter(this,listaUrl)
        recyclerView.adapter = adapter
    }

    // Método para convertir la lista de URLs en formato String a formato Uri
    private fun conversionUrl() : ArrayList<Uri>{
        this.listaString = intent.getStringArrayListExtra("LISTA_URL") as ArrayList<String>
        val listaUrl : ArrayList<Uri> = ArrayList()

        // Convierte cada URL en formato String a formato Uri y la añade a la lista
        for (uriString in listaString){
            try {
                val uri : Uri = Uri.parse(uriString)
                listaUrl.add(uri)
            }catch (e : Exception){
                // Si no se puede convertir la URL, muestra un mensaje
                Toast.makeText(this,"No se a podido añadir a la lista",Toast.LENGTH_SHORT).show()
            }
        }
        return listaUrl
    }

    //metodo para mostrar el menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.volver,menu)
        return super.onCreateOptionsMenu(menu)
    }

    //metodo para dar la funcionalidad al menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.mVolver -> {
                // Cuando se selecciona "Volver", se crea un Intent para iniciar MainActivity
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("LISTA_URL",listaString)
                startActivity(intent)
                return true
            }
        else -> return super.onOptionsItemSelected(item)
        }
    }
}