package com.tata.homeiot.ui.navigation

sealed class Route(val route: String) {

    object Login : Route("login")

    object Signup : Route("signup")

    object Home : Route("home")

    object DeviceDetail : Route("device_detail/{deviceId}") {
        fun createRoute(deviceId: String): String {
            return "device_detail/$deviceId"
        }
    }

    object Cctv : Route("cctv")

    object Profile : Route("profile")
}
