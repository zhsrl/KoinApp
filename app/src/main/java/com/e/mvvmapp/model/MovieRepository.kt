package com.e.mvvmapp.model

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import org.koin.experimental.property.inject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieRepository(application: Application, val movieApi: RetrofitService.MovieApi ) {


    fun getMovie(onResult: (isSuccess: Boolean, response: List<Movie>?) -> Unit){
        movieApi
            .getPopularMovies("633b0d5400a1437826672c9966199c0b")
            .enqueue(object: Callback<MovieResponse> {
            override fun onResponse(
                call: Call<MovieResponse>,
                response: Response<MovieResponse>) {

                if(response.isSuccessful)
                    onResult(true,response.body()!!.getResults())
                else
                    onResult(false, null)
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                onResult(false,null)
            }

        })
    }


}

