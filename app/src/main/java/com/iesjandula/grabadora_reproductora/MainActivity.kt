package com.iesjandula.grabadora_reproductora

import PlayVideoActivity
import RecordVideoActivity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.GrabarVideo -> {
                val intentGrabarVideo = Intent(this, RecordVideoActivity::class.java)
                startActivity(intentGrabarVideo)
            }
            R.id.ReproducirVideo -> {
                val intentReproducirVideo = Intent(this, PlayVideoActivity::class.java)
                startActivity(intentReproducirVideo)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}