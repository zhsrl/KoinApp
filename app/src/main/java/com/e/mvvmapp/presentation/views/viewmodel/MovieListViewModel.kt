package com.e.mvvmapp.presentation.views.viewmodel

import android.app.Application
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.e.mvvmapp.data.model.Movie
import com.e.mvvmapp.data.model.MovieRepository
import org.koin.core.logger.KOIN_TAG

class MovieListViewModel(
    val repository: MovieRepository
) : ViewModel() {


//    val repository: MovieRepository? = null
    val liveData = MutableLiveData<State>()
    var movieListLiveData = MutableLiveData<List<Movie>>()

    fun fetchMovie(){
        liveData.value = State.ShowLoading
        repository.getMovie { isSuccess, response ->
            liveData.value = State.HideLoading
            if(isSuccess){
                movieListLiveData.value = response
            }
            else{
                liveData.value = State.HideLoading
                Log.d(KOIN_TAG,"Error")
            }
        }
    }



    sealed class State(){
        object HideLoading : State()
        object ShowLoading : State()
        data class Result(val list: List<Movie>?) : State()
    }

}