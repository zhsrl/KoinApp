package com.e.mvvmapp.di

import com.e.mvvmapp.model.MovieRepository
import com.e.mvvmapp.model.RetrofitService
import com.e.mvvmapp.presentation.views.viewmodel.MovieListViewModel
import org.koin.android.viewmodel.dsl.viewModel

import org.koin.dsl.module

val viewModelModule = module {
    viewModel{ MovieListViewModel(get(), get()) }
}

val repositoryModule = module {
    factory { MovieRepository(get(), get()) }
}

val networkModule = module{
    single{RetrofitService.getMovie(get())}
}