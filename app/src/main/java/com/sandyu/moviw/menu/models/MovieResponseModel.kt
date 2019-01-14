package com.sandyu.moviw.menu.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class MovieResponseModel (
    @SerializedName("results") @Expose var results: MutableList<Moviw>
){
    data class Moviw(
        @SerializedName("poster_path") @Expose var poster: String,
        @SerializedName("title") @Expose var title: String,
        @SerializedName("release_date") @Expose var date: String,
        @SerializedName("overview") @Expose var overview:String
    )
}