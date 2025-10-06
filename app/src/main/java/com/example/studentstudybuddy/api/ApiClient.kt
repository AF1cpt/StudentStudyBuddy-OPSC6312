package com.example.studentstudybuddy.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import javax.inject.Singleton

// Singleton object to provide a Retrofit instance, configured for Hilt
@Singleton
class ApiClient @Inject constructor() {
    val service: OpenLibraryService by lazy {
        Retrofit.Builder()
            .baseUrl("https://openlibrary.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(OpenLibraryService::class.java)
    }
}