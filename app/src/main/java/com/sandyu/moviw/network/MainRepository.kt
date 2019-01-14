package com.sandyu.moviw.network

import com.sandyu.moviw.menu.models.MovieResponseModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainRepository {
    private val apiService = ServiceFactory.create()
    private val compositeDisposable =  CompositeDisposable()

    fun requestMovie(onResult: (MovieResponseModel) -> Unit, onError: (Throwable) -> Unit){
        apiService.getMovie()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object: ApiObserver<MovieResponseModel>(compositeDisposable){
                override fun onApiSuccess(data: MovieResponseModel) {
                    onResult(data)
                }

                override fun onApiError(er: Throwable) {
                    onError(er)
                }
            })
    }

    fun onDestroy(){
        compositeDisposable.clear()
    }
}