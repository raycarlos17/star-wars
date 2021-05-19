package com.star_wars

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class InformacoesPersonagens : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_informacoes_personagens)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}