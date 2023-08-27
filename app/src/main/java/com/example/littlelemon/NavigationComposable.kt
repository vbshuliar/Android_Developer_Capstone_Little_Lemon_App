package com.example.littlelemon

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun Navigation(navController: NavHostController, database: AppDatabase) {
    val hasUserData = checkUserDataInSharedPreferences()
    NavHost(
        navController = navController,
        startDestination = if (hasUserData) Home.route else Onboarding.route
    ) {
        composable(Onboarding.route) {
            Onboarding(navController)
        }
        composable(Home.route) {
            Home(navController, database)
        }
        composable(Profile.route) {
            Profile(navController)
        }
    }
}

@Composable
fun checkUserDataInSharedPreferences(): Boolean {
    val context = LocalContext.current
    val sharedPreferences = context.getSharedPreferences("user_data", Context.MODE_PRIVATE)
    return sharedPreferences.contains("first_name")
}
