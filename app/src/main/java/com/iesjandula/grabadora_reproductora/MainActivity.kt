package com.iesjandula.grabadora_reproductora

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.mGrabarVideo -> {
                val intentGrabarVideo = Intent(this, GrabarVideo::class.java)
                startActivity(intentGrabarVideo)
            }
            R.id.mReproducirVideo -> {
                val intentReproducirVideo = Intent(this, ReproducirVideo::class.java)
                startActivity(intentReproducirVideo)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}