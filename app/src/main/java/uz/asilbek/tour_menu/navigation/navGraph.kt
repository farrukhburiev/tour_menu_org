package shamsiddin.project.tourvibe.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import shamsiddin.project.tourvibe.screen.menu.Menu


@Composable
fun SetNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = ScreenType.Menu.route) {
        composable(ScreenType.Menu.route) {
            Menu(navController)
        }


    }
}