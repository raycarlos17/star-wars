package com.star_wars.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.star_wars.R

class InformacoesPersonagens : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_informacoes_personagens)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}