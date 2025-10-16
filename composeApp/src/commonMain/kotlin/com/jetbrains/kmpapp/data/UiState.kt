package com.jetbrains.kmpapp.data

data class UiState(
    val isLoading: Boolean = false,
    val isLoggedIn: Boolean = false,
    val errorMessage: String? = null,
    val toastMessage: String? = null
)

