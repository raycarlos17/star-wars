package com.star_wars.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.star_wars.R
import kotlinx.android.synthetic.main.activity_menu_principal.*

class MenuPrincipal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_principal)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        btn_planetas.setOnClickListener {
            telaListaPlanetas()
        }

        btn_personagens.setOnClickListener {
            telaGaleriaPersonagens()
        }
    }

    private fun telaListaPlanetas() {
        val intent = Intent(this, ListaPlanetas::class.java)
        startActivity(intent)
    }

    private fun telaGaleriaPersonagens() {
        val intent = Intent(this, GaleriaPersonagens::class.java)
        startActivity(intent)
    }
}