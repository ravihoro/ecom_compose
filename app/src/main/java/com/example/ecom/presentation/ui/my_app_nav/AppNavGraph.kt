package com.example.ecom.presentation.ui.my_app_nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.ecom.presentation.ui.home.HomeScreen
import com.example.ecom.presentation.ui.product_detail.ProductDetailScreen

object Routes {
    const val HOME = "home"
    const val PRODUCT = "product/{productId}"
}

@Composable
fun AppNavGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.HOME
    ){
        composable(Routes.HOME) { backStackEntry ->
            HomeScreen(
                navController = navController
            )
        }

        composable(
            route = Routes.PRODUCT,
            arguments = listOf(navArgument("productId") { type = NavType.IntType })
        ) { backStackEntry ->
            ProductDetailScreen()
        }
    }
}
