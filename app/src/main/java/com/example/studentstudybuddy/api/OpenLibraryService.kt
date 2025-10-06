package com.example.studentstudybuddy.api

import com.example.studentstudybuddy.data.model.BookSearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

// Defines the endpoints for the Open Library API
interface OpenLibraryService {
    @GET("search.json")
    suspend fun searchBooks(@Query("q") query: String): BookSearchResponse
}