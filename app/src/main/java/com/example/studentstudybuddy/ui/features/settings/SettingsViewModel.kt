package com.example.studentstudybuddy.ui.features.settings

import androidx.lifecycle.ViewModel
import com.example.studentstudybuddy.data.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(private val repo: AuthRepository) : ViewModel() {
    fun logout() {
        repo.logout()
    }
}