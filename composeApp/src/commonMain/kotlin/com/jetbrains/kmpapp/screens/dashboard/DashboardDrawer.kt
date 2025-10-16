package com.jetbrains.kmpapp.screens.dashboard

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.jetbrains.kmpapp.navigation.Screen
import kotlinx.coroutines.launch


@Composable
fun DashboardDrawer(
    dashboardNavController: NavHostController,
    drawerState: DrawerState
) {

    val items = listOf(
        Screen.Dashboard to "Dashboard",
        Screen.History to "History",
        Screen.Setting to "Setting",
        Screen.Profile to "Profile",
        Screen.Logout to "Logout"
    )

    val currentDestination by dashboardNavController.currentBackStackEntryAsState()
    val currentRoute = currentDestination?.destination?.route
    val coroutineScope = rememberCoroutineScope()

    ModalDrawerSheet {
        Spacer(modifier = Modifier.padding(vertical = 5.dp))

        items.forEach { (screen, title) ->
            NavigationDrawerItem(
                label = { Text(text = title) },
                selected = currentRoute == screen.route,
                onClick = {
                    coroutineScope.launch { drawerState.close() }
                    dashboardNavController.navigate(screen.route) {
                        // Clear backstack to start destination
                        popUpTo(dashboardNavController.graph.startDestinationId) {
                            saveState = true
                        }
                        launchSingleTop = true   // Avoid multiple copies of the same destination
                        restoreState = true      // Restore previous state when reselecting
                    }
                },
                modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
            )
        }
    }

//    val items = listOf(
//        Screen.Dashboard to "Dashboard",
//        Screen.History to "History",
//        Screen.Setting to "Setting",
//        Screen.Profile to "Profile"
//    )
//
//    // Track the current route to highlight the active drawer item
//    val currentDestination by navController.currentBackStackEntryAsState()
//    val currentRoute = currentDestination?.destination?.route
//    val coroutineScope = rememberCoroutineScope()
//
//    ModalNavigationDrawer(
//        drawerState = drawerState,
//        drawerContent = {
//            ModalDrawerSheet {
////                Text(
////                    text = "Dashboard",
////                    modifier = Modifier.padding(16.dp),
////                    style = androidx.compose.material3.MaterialTheme.typography.titleLarge
////                )
//                Spacer(modifier = Modifier.padding(vertical = 5.dp))
//
//                items.forEach { (screen, title) ->
//                    NavigationDrawerItem(
//                        label = { Text(text = title) },
//                        selected =  currentRoute == screen.route,
//                        onClick = {
//                            coroutineScope.launch { drawerState.close() }
//                            navController.navigate(screen.route){
//                                popUpTo(navController.graph.startDestinationId){
//                                    saveState = true
//                                }
//                                launchSingleTop = true
//                                restoreState = true
//                            }
//                        },
//                        modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
//    )
//                }
//            }
//        }
//    ) {
//        AppNavGraph(navController = navController)
//    }


}