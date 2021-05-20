package com.star_wars.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ListaPlanetasMyRetrofit {

    companion object {
        const val BASE_URL = "https://swapi.dev/api/"
    }

    private fun listaPlanetasProvider(): Retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()

    fun retrofitApi(): ListaPlanetasApi = listaPlanetasProvider().create(ListaPlanetasApi::class.java)
}