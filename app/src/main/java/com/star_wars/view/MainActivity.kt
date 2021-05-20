package com.star_wars.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.star_wars.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_conectar.setOnClickListener{
            conectarApp()
        }

    }

    private fun conectarApp() {
        val intent = Intent(this, MenuPrincipal::class.java)
        startActivity(intent)
    }

}