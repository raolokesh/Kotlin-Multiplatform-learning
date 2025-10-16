package com.jetbrains.kmpapp.screens.base

import androidx.lifecycle.ViewModel
import com.jetbrains.kmpapp.data.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

open class BaseViewModel() : ViewModel() {
    // Backing property
    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState

    /** Show progress bar */
    fun showLoading() {
        _uiState.update { it.copy(isLoading = true) }
    }

    /** Hide progress bar */
    fun hideLoading() {
        _uiState.update { it.copy(isLoading = false) }
    }

    /** Update login state */
    fun setLoggedIn(loggedIn: Boolean) {
        _uiState.update { it.copy(isLoggedIn = loggedIn) }
    }

    /** Show an error message */
    fun showError(message: String) {
        _uiState.update { it.copy(errorMessage = message) }
    }

    /** Clear error message after displaying */
    fun clearError() {
        _uiState.update { it.copy(errorMessage = null) }
    }

    // Toast
    fun showToast(message: String) {
        _uiState.update { it.copy(toastMessage = message) }
    }

    fun clearToast() {
        _uiState.update { it.copy(toastMessage = null) }
    }


}