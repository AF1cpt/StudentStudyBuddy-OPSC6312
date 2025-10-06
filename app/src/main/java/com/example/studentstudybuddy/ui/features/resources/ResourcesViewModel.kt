package com.example.studentstudybuddy.ui.features.resources

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.studentstudybuddy.api.ApiClient
import com.example.studentstudybuddy.data.model.Book
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

data class ResourcesUiState(
    val isLoading: Boolean = false,
    val books: List<Book> = emptyList(),
    val error: String? = null
)

@HiltViewModel
class ResourcesViewModel @Inject constructor(private val apiClient: ApiClient) : ViewModel() {
    private val _uiState = MutableLiveData<ResourcesUiState>()
    val uiState: LiveData<ResourcesUiState> = _uiState

    fun searchBooks(query: String) {
        if (query.length < 3) return
        viewModelScope.launch {
            _uiState.value = ResourcesUiState(isLoading = true)
            try {
                val response = apiClient.service.searchBooks(query)
                _uiState.value = ResourcesUiState(books = response.docs)
            } catch (e: Exception) {
                _uiState.value = ResourcesUiState(error = e.message)
            }
        }
    }
}