package com.star_wars.model

import com.google.gson.annotations.SerializedName

data class ListaPlanetasModel(
    @SerializedName("results")
    val results: List<Planeta>
)