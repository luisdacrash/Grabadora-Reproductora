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
import java.lang.Exception

class ReproducirVideo : AppCompatActivity() {

    lateinit var listaString : ArrayList<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reproducir_video)

        val recyclerView : RecyclerView = findViewById(R.id.recicloso)
        val listaUrl : ArrayList<Uri> = conversionUrl()
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        val adapter = VideoAdapter(this,listaUrl)
        recyclerView.adapter = adapter
    }

    private fun conversionUrl() : ArrayList<Uri>{
        this.listaString = intent.getStringArrayListExtra("LISTA_URL") as ArrayList<String>
        val listaUrl : ArrayList<Uri> = ArrayList()

        for (uriString in listaString){
            try {
                val uri : Uri = Uri.parse(uriString)
                listaUrl.add(uri)
            }catch (e : Exception){
                Toast.makeText(this,"No se a podido añadir a la lista",Toast.LENGTH_SHORT).show()
            }
        }
        return listaUrl
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.volver,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.mVolver -> {
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("LISTA_URL",listaString)
                startActivity(intent)
                return true
            }
        else -> return super.onOptionsItemSelected(item)
        }
    }
}