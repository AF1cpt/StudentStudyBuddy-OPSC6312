package com.example.studentstudybuddy.data.model

import com.google.gson.annotations.SerializedName

// Models the JSON response from the Open Library API
data class BookSearchResponse(
    val docs: List<Book>
)

data class Book(
    val title: String,
    @SerializedName("author_name") val authorName: List<String>?
)