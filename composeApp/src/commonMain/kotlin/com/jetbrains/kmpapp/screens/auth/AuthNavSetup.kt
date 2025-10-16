package com.jetbrains.kmpapp.screens.auth

import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope

import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.jetbrains.kmpapp.navigation.AuthNavGraph


@Composable
fun AuthNavSetup(rootNavController: NavHostController) {

    val authNavController = rememberNavController()
    val scope = rememberCoroutineScope()

    AuthNavGraph(authNavController = authNavController, rootNavController = rootNavController)

}