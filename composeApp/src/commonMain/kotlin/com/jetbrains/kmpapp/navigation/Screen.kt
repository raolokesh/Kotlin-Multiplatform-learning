package com.jetbrains.kmpapp.navigation

import kotlinx.serialization.Serializable


sealed class Screen(val route : String){


    object DashboardSetup : Screen("dashboard_setup")
    object Dashboard : Screen("dashboard")
    object History : Screen("history")
    object Setting : Screen("setting")
    object Profile : Screen("profile")

    object Login : Screen("login")
    object SignUp : Screen("signup")
    object Forgot : Screen("forgot")

    object Logout : Screen("logout")


    object Details : Screen("details/{id}"){
        fun createRoute(id: Int) = "details/$id"
    }
}