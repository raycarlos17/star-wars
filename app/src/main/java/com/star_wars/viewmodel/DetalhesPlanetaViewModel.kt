package com.star_wars.viewmodel

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.star_wars.api.ListaPlanetasMyRetrofit
import com.star_wars.model.Planeta
import com.star_wars.repository.ListaPlanetasRepository

class DetalhesPlanetaViewModel: ViewModel() {
    private val listaPlanetasMyRetrofit = ListaPlanetasMyRetrofit()
    private val listaPlanetasRepository = ListaPlanetasRepository(listaPlanetasMyRetrofit)

    private var _planetasDetalhes = MutableLiveData<Planeta>()
    val planetasDetalhes: LiveData<Planeta>
        get() = _planetasDetalhes

    fun init(planetaId: Int, context: Context){
        getPlanetasDetalhes(planetaId, context)
    }

    private fun getPlanetasDetalhes(planetaId: Int, context: Context) {
        listaPlanetasRepository.getDetalhesPlaneta(planetaId, context, ::onRequestSuccess, ::onRequestError)
    }

    private fun onRequestSuccess(planeta: Planeta) {
        _planetasDetalhes.postValue(planeta)
    }

    private fun onRequestError(context: Context, code: Int?) {
        if(code != null) {
            Toast.makeText(context, "Error $code", Toast.LENGTH_SHORT)
        } else {
            Toast.makeText(context, "Unable to load movie details", Toast.LENGTH_SHORT)
        }
    }
}