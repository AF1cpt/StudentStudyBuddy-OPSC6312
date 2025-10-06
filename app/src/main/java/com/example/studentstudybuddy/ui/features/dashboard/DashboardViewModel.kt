package com.example.studentstudybuddy.ui.features.dashboard

import androidx.lifecycle.ViewModel
import com.example.studentstudybuddy.data.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(repo: AuthRepository) : ViewModel() {
    val welcomeMessage = "Welcome, ${repo.getCurrentUser()?.email ?: "User"}!"
}