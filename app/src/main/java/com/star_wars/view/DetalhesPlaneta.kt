package com.star_wars.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.star_wars.R
import com.star_wars.model.Planeta
import com.star_wars.viewmodel.DetalhesPlanetaViewModel
import com.star_wars.viewmodel.ListaPlanetasViewModel
import kotlinx.android.synthetic.main.activity_detalhes_planeta.*

class DetalhesPlaneta : AppCompatActivity() {

    private lateinit var detalhesPlanetaViewModel: DetalhesPlanetaViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhes_planeta)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        detalhesPlanetaViewModel = ViewModelProvider.NewInstanceFactory().create(DetalhesPlanetaViewModel::class.java)
        detalhesPlanetaViewModel.init(intent.getIntExtra("id", -1), applicationContext)

        initObserver()
    }

    private fun initObserver() {
        detalhesPlanetaViewModel.planetasDetalhes.observe(this, Observer {
            setUpPlaneta(it)
        })
    }

    private fun setUpPlaneta(planeta: Planeta) {
        tv_nome_planeta.text = planeta.name
        tv_clima_planeta.text = planeta.climate
        tv_populacao_planeta.text = planeta.population
    }

}