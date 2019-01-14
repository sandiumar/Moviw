package com.sandyu.moviw.menu.viewmodels


import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.sandyu.moviw.menu.models.MovieResponseModel
import com.sandyu.moviw.network.MainRepository

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = MainRepository()

    var movies : MutableLiveData<MovieResponseModel> = MutableLiveData()
    var error : MutableLiveData<Throwable> = MutableLiveData()

    fun getMovie(){
        repository.requestMovie({
            movies.postValue(it)
        },{
            error.postValue(it)
        })
    }

    override fun onCleared() {
        super.onCleared()
        repository.onDestroy()
    }

}

