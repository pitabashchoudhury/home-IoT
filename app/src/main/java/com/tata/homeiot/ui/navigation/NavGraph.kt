package com.tata.homeiot.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.tata.homeiot.ui.home.HomeScreen

@Composable
fun HomeIotNavGraph(
    navController: NavHostController,
    startDestination: String = Route.Home.route,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {

//        composable(Route.Login.route) {
//            val vm: AuthViewModel = hiltViewModel()
//            LoginScreen(
//                viewModel = vm,
//                onLoginSuccess = {
//                    navController.navigate(Route.Home.route) {
//                        popUpTo(Route.Login.route) { inclusive = true }
//                    }
//                },
//                onSignupClick = {
//                    navController.navigate(Route.Signup.route)
//                }
//            )
//        }
//
//        composable(Route.Signup.route) {
//            val vm: AuthViewModel = hiltViewModel()
//            SignupScreen(
//                viewModel = vm,
//                onSignupSuccess = {
//                    navController.popBackStack()
//                }
//            )
//        }

        composable(Route.Home.route) {

            HomeScreen(


            )
        }

//        composable(
//            route = Route.DeviceDetail.route,
//            arguments = listOf(
//                navArgument("deviceId") {
//                    type = NavType.StringType
//                }
//            )
//        ) {
//            val vm: DeviceDetailViewModel = hiltViewModel()
//            DeviceDetailScreen(vm)
//        }
//
//        composable(Route.Cctv.route) {
//            CctvScreen(
//                onBack = { navController.popBackStack() }
//            )
//        }
//
//        composable(Route.Profile.route) {
//            ProfileScreen(
//                onLogout = {
//                    navController.navigate(Route.Login.route) {
//                        popUpTo(0)
//                    }
//                }
//            )
//        }
    }
}
