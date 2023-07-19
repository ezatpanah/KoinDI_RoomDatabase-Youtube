package com.ezatpanah.koindi_roomdatabase_youtube.di

import com.ezatpanah.koindi_roomdatabase_youtube.repository.DatabaseRepository
import com.ezatpanah.koindi_roomdatabase_youtube.viewmodel.DatabaseViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val databaseModule = module {

    single { provideDatabase(androidContext()) }
    single { provideDao(get()) }
    factory { DatabaseRepository(get()) }
    viewModel() { DatabaseViewModel(get()) }

}