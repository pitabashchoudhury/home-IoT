package com.tata.homeiot.ui.navigation

sealed class Route(val route: String) {

    // Root
    object Splash : Route("splash")
    object Error : Route("error")
    object NoInternet : Route("no_internet")

    // Auth
    object Login : Route("login")
    object Signup : Route("signup")

    // Main
    object Home : Route("home")

    // Bulb
    object BulbList : Route("bulb_list")
    object BulbDetail : Route("bulb_detail/{bulbId}") {
        fun createRoute(bulbId: String) = "bulb_detail/$bulbId"
    }
}

