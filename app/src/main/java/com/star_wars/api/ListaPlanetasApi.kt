package com.star_wars.api

import com.star_wars.model.ListaPlanetasModel
import com.star_wars.model.Planeta
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ListaPlanetasApi {

    companion object{
        const val LISTA_PLANETA = "planets/"
    }

    @GET(LISTA_PLANETA)
    fun getListaPlanetasApi(): Call<ListaPlanetasModel>

    @GET(LISTA_PLANETA)
    fun getDestalhesPlanetaApi(@Path("id") id: Int): Call<Planeta>
}