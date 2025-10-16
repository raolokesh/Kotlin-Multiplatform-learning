package com.jetbrains.kmpapp.screens.dashboard

import androidx.lifecycle.viewModelScope
import com.jetbrains.kmpapp.screens.base.BaseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class DashboardViewModel(
) : BaseViewModel() {

    fun loadDashboard() {
        showLoading()
        viewModelScope.launch {
            try {
                delay(2000)
                hideLoading()
                showToast("Dashboard data loaded!")
            } catch (e: Exception) {
                hideLoading()
                showError("Failed to load dashboard: ${e.message}")
            }
        }
    }
}