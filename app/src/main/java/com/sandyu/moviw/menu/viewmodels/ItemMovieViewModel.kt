package com.sandyu.moviw.menu.viewmodels

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.sandyu.moviw.menu.models.MovieResponseModel


class ItemMovieViewModel(model: MovieResponseModel.Moviw): ViewModel() {
    var title: ObservableField<String> = ObservableField()
    var overview: ObservableField<String> = ObservableField()
    var poster: ObservableField<String> = ObservableField()
    var date : ObservableField<String> = ObservableField()

    init {
        title.set(model.title)
        overview.set(model.overview)
        poster.set(model.poster)
        date.set(model.date)
    }
}