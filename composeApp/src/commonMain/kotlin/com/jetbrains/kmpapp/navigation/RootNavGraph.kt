package com.jetbrains.kmpapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.jetbrains.kmpapp.screens.auth.AuthNavSetup
import com.jetbrains.kmpapp.screens.dashboard.DashboardSetup
import com.jetbrains.kmpapp.screens.detail.DetailsScreen


@Composable
fun RootNavGraph(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = Screen.Login.route
    ) {
        composable(route = Screen.DashboardSetup.route) {
            DashboardSetup(navController)
        }

        composable(route = Screen.Login.route) {
            AuthNavSetup(navController)
        }

        composable(
            route = Screen.Details.route,
            arguments = listOf(navArgument("id") { type = NavType.IntType })
        ) { backStackEntry ->
//            val id = backStackEntry.arguments?.getInt("id")
            DetailsScreen(id = 100, {
                navController.popBackStack()
            })
        }

    }


}