package com.cavies.focusflow.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.cavies.focusflow.ui.view.NavHostViewModel
import com.cavies.focusflow.ui.view.home.HomeView
import com.cavies.focusflow.ui.view.splash.SplashView

@Composable
fun AppNavHost(
    navController: NavHostController = rememberNavController(),
) {
    val navHostViewModel: NavHostViewModel = hiltViewModel()
    val navManager = navHostViewModel.navManager

    LaunchedEffect(Unit) {
        navManager.commands.collect { command ->
            when (command) {
                is NavigationCommand.NavigateTo -> {
                    navController.navigate(command.route) {
                        launchSingleTop = command.singleTop
                    }
                }
                is NavigationCommand.NavigateAndPop -> {
                    navController.navigate(command.route) {
                        popUpTo(command.popUpTo) { inclusive = command.inclusive }
                    }
                }
                NavigationCommand.NavigateUp -> navController.navigateUp()
                NavigationCommand.PopBack -> navController.popBackStack()
            }
        }
    }

    NavHost(
        navController = navController,
        startDestination = "splash"
    ) {
        composable("splash") { SplashView() }
        composable("home") { HomeView() }
    }
}

