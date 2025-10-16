package com.jetbrains.kmpapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.jetbrains.kmpapp.screens.auth.ForgotScreen
import com.jetbrains.kmpapp.screens.auth.LoginScreen
import com.jetbrains.kmpapp.screens.auth.SignUpScreen


@Composable
fun AuthNavGraph(
    authNavController: NavHostController,
    rootNavController: NavHostController
) {

    NavHost(navController = authNavController, startDestination = Screen.Login.route) {

        composable(route = Screen.Login.route) {
            LoginScreen(
                onSignUpClick = {
                    authNavController.navigate(Screen.SignUp.route) {
                        launchSingleTop = true
                    }
                },
                onForgotClick = {
                    authNavController.navigate(Screen.Forgot.route) {
                        launchSingleTop = true
                    }
                },
                onLoginButton = {
                    rootNavController.navigate(Screen.DashboardSetup.route) {
                        popUpTo(Screen.Login.route) {
                            inclusive = true
                        }
                    }
                })
        }

        composable(route = Screen.SignUp.route) {
            SignUpScreen(
                onLoginClick = {
                    authNavController.navigate(Screen.Login.route) {
                        launchSingleTop = true
                    }
                }
            )
        }

        composable(route = Screen.Forgot.route) {
            ForgotScreen(
                onLoginClick = {
                    authNavController.navigate(Screen.Login.route) {
                        launchSingleTop = true
                    }
                }
            )
        }


    }
}