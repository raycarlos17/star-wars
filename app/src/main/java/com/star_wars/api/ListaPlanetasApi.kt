package com.star_wars.api

import com.star_wars.model.ListaPlanetasModel
import retrofit2.Call
import retrofit2.http.GET

interface ListaPlanetasApi {
    @GET("planets/")
    fun getListaPlanetasApi(): Call<List<ListaPlanetasModel>>
}