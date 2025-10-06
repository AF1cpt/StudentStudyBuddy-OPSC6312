package com.example.studentstudybuddy.data.model

import com.google.firebase.firestore.DocumentId

// Represents a single note in Firestore
data class Note(
    @DocumentId val id: String = "",
    val userId: String = "",
    val title: String = "",
    val content: String = ""
)