package com.jetbrains.kmpapp.screens.dashboard

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.jetbrains.kmpapp.navigation.AppNavGraph
import kotlinx.coroutines.launch


@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun DashboardSetup(navController: NavHostController) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    val dashboardNavController = rememberNavController()

    // Wrap the entire dashboard inside ModalNavigationDrawer
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            DashboardDrawer(
                dashboardNavController = dashboardNavController,
                drawerState = drawerState
            )
        }
    ) {
        Scaffold(
            topBar = {
                CenterAlignedTopAppBar(
                    title = { Text("Dashboard") },
                    navigationIcon = {
                        IconButton(onClick = {
                            scope.launch {
                                if (drawerState.isOpen) {
                                    drawerState.close()
                                } else {
                                    drawerState.open()
                                }
                            }
                        }) {
                            Icon(Icons.Default.Menu, contentDescription = "Menu")
                        }
                    }
                )
            }
        ) { innerPadding ->
            Box(modifier = Modifier.padding(innerPadding)) {
                // ✅ Keep NavHost here
                AppNavGraph(
                    navController = dashboardNavController,
                    rootNavController = navController //

                    )
            }
        }
    }

//    Scaffold(
//        topBar = {
//            CenterAlignedTopAppBar(
//                title = { Text(text = "Dashboard") },
//                navigationIcon = {
//                    IconButton(onClick = {
//                        scope.launch {
//                            when (drawerState.isOpen) {
//                                true -> drawerState.close()
//                                false -> drawerState.open()
//                            }
//                        }
//                    }) {
//                        Icon(Icons.Default.Menu, contentDescription = "Menu")
//                    }
//                }
//            )
//        }
//    ) { innerPadding ->
//        Box(modifier = Modifier.padding(innerPadding)) {
//            DashboardDrawer(navController = navController, drawerState = drawerState)
//        }
//
//    }

}