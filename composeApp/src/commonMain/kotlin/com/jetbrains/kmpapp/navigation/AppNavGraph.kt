package com.jetbrains.kmpapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.jetbrains.kmpapp.screens.dashboard.DashboardScreen
import com.jetbrains.kmpapp.screens.history.HistoryScreen
import com.jetbrains.kmpapp.screens.profile.ProfileScreen
import com.jetbrains.kmpapp.screens.setting.SettingScreen


@Composable
fun AppNavGraph(
    navController: NavHostController,
    rootNavController: NavHostController
) {
    NavHost(navController = navController, startDestination = Screen.Dashboard.route) {
        composable(route = Screen.Dashboard.route) {
            DashboardScreen(onClickNextScreen = { id ->
                rootNavController.navigate(Screen.Details.createRoute(id)) {
                    launchSingleTop = true
                }
            })
        }
        composable(route = Screen.History.route) {
            HistoryScreen()
        }
        composable(route = Screen.Setting.route) {
            SettingScreen()
        }
        composable(route = Screen.Profile.route) {
            ProfileScreen()
        }

        composable(route = Screen.Logout.route) {
            rootNavController.navigate(Screen.Login.route) {
                popUpTo(Screen.DashboardSetup.route) {
                    inclusive = true
                }
            }
        }

//        composable(route = Screen.Details.route,
//            arguments = listOf(navArgument("id") { type = NavType.IntType })
//        ) { backStackEntry ->
//            val id = backStackEntry.arguments?.getInt("id")
//            DetailsScreen(id = id, { })
//        }

    }

}