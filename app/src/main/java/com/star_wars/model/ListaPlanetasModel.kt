package com.star_wars.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ListaPlanetasModel(
    @SerializedName("name")
    val name: String,
    @SerializedName("climate")
    val climate: String,
    @SerializedName("population")
    val population: String,
    @SerializedName("results")
    val results: ArrayList<String>,
): Parcelable