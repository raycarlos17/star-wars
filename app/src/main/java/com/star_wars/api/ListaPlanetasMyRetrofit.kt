package com.star_wars.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ListaPlanetasMyRetrofit {
    private val retrofit: Retrofit

    fun listaPlanetasApi(): ListaPlanetasApi {
        return retrofit.create(ListaPlanetasApi::class.java)
    }

    companion object {
        private const val BASE_URL = "https://swapi.dev/api/"

        var listaPlanetasMyRetrofit: ListaPlanetasMyRetrofit? = null

        @get:Synchronized
        val instance: ListaPlanetasMyRetrofit?
            get() {
                if (listaPlanetasMyRetrofit == null) {
                    listaPlanetasMyRetrofit = ListaPlanetasMyRetrofit()
                }
                return listaPlanetasMyRetrofit
            }
    }

    init {
        retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
    }
}