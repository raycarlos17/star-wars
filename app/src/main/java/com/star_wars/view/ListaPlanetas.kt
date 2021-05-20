package com.star_wars.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.star_wars.ListaPlanetasAdapter
import com.star_wars.R
import com.star_wars.api.ListaPlanetasMyRetrofit
import com.star_wars.model.Planeta
import com.star_wars.viewmodel.ListaPlanetasViewModel
import kotlinx.android.synthetic.main.activity_lista_planetas.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListaPlanetas : AppCompatActivity() {

    private lateinit var listaPlanetasViewModel: ListaPlanetasViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_planetas)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        listaPlanetasViewModel = ViewModelProvider.NewInstanceFactory().create(ListaPlanetasViewModel::class.java)
        listaPlanetasViewModel.init(applicationContext)
        initObserver()
        loadingVisibility(true)
    }

    private fun initObserver() {
        listaPlanetasViewModel.listaPlanetas.observe(this, Observer {
            if(it.isNotEmpty()) {
                populateList(it)
                loadingVisibility(false)
            }
        })
    }

    private fun populateList(list: List<Planeta>) {
        rv_lista_planetas.apply {
            hasFixedSize()
            adapter = ListaPlanetasAdapter(list) {onClickItemPlaneta(it.id)}
        }
    }

    private fun onClickItemPlaneta(id: Int) {
        val intent = Intent(this, DetalhesPlaneta::class.java)
        intent.putExtra("id", id)
        startActivity(intent)
    }

    private fun loadingVisibility(isLoading: Boolean) {
        progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
    }
}