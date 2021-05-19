package com.star_wars

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class GaleriaPersonagens : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_galeria_personagens)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}