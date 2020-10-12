package com.e.mvvmapp.di

import com.e.mvvmapp.data.model.MovieRepository
import com.e.mvvmapp.data.model.RetrofitService
import com.e.mvvmapp.presentation.views.viewmodel.MovieListViewModel
import org.koin.android.viewmodel.dsl.viewModel

import org.koin.dsl.module

val viewModelModule = module {
    viewModel{ MovieListViewModel(repository = get()) }
}

val repositoryModule = module {
    single { MovieRepository(context = get()) }
}

val networkModule = module{
    single { RetrofitService.getMovie()}
}
