package com.sandyu.moviw.network

import com.sandyu.moviw.menu.models.MovieResponseModel
import io.reactivex.Observable
import retrofit2.http.GET

interface RestApi {
    @GET("upcoming?api_key=78adf61cd991fec888c055105c148a44")
    fun getMovie(): Observable<MovieResponseModel>
}