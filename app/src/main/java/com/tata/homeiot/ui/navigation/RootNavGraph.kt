package com.tata.homeiot.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.tata.homeiot.ui.home.HomeScreen

@Composable
fun RootNavGraph(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = Route.Splash.route
    ) {

        composable(Route.Splash.route) {
//            SplashScreen(
//                onAuthRequired = {
//                    navController.navigate(Route.Login.route) {
//                        popUpTo(Route.Splash.route) { inclusive = true }
//                    }
//                },
//                onHome = {
//                    navController.navigate(Route.Home.route) {
//                        popUpTo(Route.Splash.route) { inclusive = true }
//                    }
//                }
//            )
        }

        authGraph(navController)
        mainGraph(navController)

        composable(Route.Error.route) {
           // ErrorScreen()
        }

        composable(Route.NoInternet.route) {
           // NoInternetScreen()
        }
    }
}


fun NavGraphBuilder.authGraph(navController: NavHostController) {

    navigation(
        startDestination = Route.Login.route,
        route = "auth_graph"
    ) {

        composable(Route.Login.route) {
//            LoginScreen(
//                onLoginSuccess = {
//                    navController.navigate(Route.Home.route) {
//                        popUpTo("auth_graph") { inclusive = true }
//                    }
//                },
//                onSignup = {
//                    navController.navigate(Route.Signup.route)
//                }
//            )
        }

        composable(Route.Signup.route) {
//            SignupScreen(
//                onSignupSuccess = {
//                    navController.popBackStack()
//                }
//            )
        }
    }
}


fun NavGraphBuilder.mainGraph(navController: NavHostController) {

    navigation(
        startDestination = Route.Home.route,
        route = "main_graph"
    ) {

        composable(Route.Home.route) {
            HomeScreen(
//                onBulbClick = {
//                    navController.navigate(Route.BulbList.route)
//                }
            )
        }

        bulbGraph(navController)
    }
}

fun NavGraphBuilder.bulbGraph(navController: NavHostController) {

    navigation(
        startDestination = Route.BulbList.route,
        route = "bulb_graph"
    ) {

        composable(Route.BulbList.route) {
//            BulbListScreen(
//                onBulbSelected = { bulbId ->
//                    navController.navigate(
//                        Route.BulbDetail.createRoute(bulbId)
//                    )
//                }
//            )
        }

//        composable(
//            route = Route.BulbDetail.route,
//            arguments = listOf(
//                navArgument("bulbId") {
//                    type = NavType.StringType
//                }
//            )
//        ) {
//            BulbDetailScreen()
//        }
    }
}


