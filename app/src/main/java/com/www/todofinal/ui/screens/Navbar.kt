package com.www.todofinal.ui.screens

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.www.todofinal.MainActivity

@Composable
fun Navbar(x: MainActivity) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home")  {Home(navController,x) }
        composable("edit"){ Edit(navController,x)}
    }

}