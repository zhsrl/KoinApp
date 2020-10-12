package com.e.mvvmapp.data.model

import android.content.Context
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MovieRepository(val context: Context ) {


    fun getMovie(onResult: (isSuccess: Boolean, response: List<Movie>) -> Unit){

        RetrofitService.getMovie()
            .getPopularMovies("633b0d5400a1437826672c9966199c0b")
            .enqueue(object: Callback<MovieResponse> {
                override fun onResponse(
                    call: Call<MovieResponse>,
                    response: Response<MovieResponse>) {

                    if(response.isSuccessful){
                        val list: List<Movie> = response.body()!!.getResults()
                        onResult(true, list)
                        Toast.makeText(context,"CONNECTED!",Toast.LENGTH_SHORT).show()
                    }
                    else
                        onResult(false, emptyList())
                        Toast.makeText(context,"NO CONNECTION",Toast.LENGTH_SHORT).show()
                }

                override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                    onResult(false, emptyList())
                    Toast.makeText(context,"ERROR",Toast.LENGTH_SHORT).show()
                }

            })

    }


}

