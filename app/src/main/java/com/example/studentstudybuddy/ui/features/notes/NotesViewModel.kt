package com.example.studentstudybuddy.ui.features.notes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.studentstudybuddy.data.repository.NotesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(private val repo: NotesRepository) : ViewModel() {
    val notes = repo.getNotes().asLiveData()

    fun addNote(title: String, content: String) {
        viewModelScope.launch {
            repo.addNote(title, content)
        }
    }
}