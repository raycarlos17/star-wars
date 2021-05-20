package com.star_wars.viewmodel

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.star_wars.api.ListaPlanetasMyRetrofit
import com.star_wars.model.Planeta
import com.star_wars.repository.ListaPlanetasRepository

class ListaPlanetasViewModel: ViewModel() {

    private val listaPlanetasMyRetrofit = ListaPlanetasMyRetrofit()
    private val listaPlanetasRepository = ListaPlanetasRepository(listaPlanetasMyRetrofit)

    private var _listaPlanetas = MutableLiveData<List<Planeta>>()

    val listaPlanetas: LiveData<List<Planeta>>
        get() = _listaPlanetas

    fun init(context: Context) {
        getListaPlanetas(context)
    }

    private fun getListaPlanetas(context: Context) {
        listaPlanetasRepository.getListaPlanetas(context, ::onRequestSuccess, ::onRequestError)
    }

    private fun onRequestSuccess(list: List<Planeta>){
        _listaPlanetas.postValue(list)
    }

    private fun onRequestError(context: Context, code: Int?){
        Toast.makeText(context, "Error $code", Toast.LENGTH_SHORT)
    }

}