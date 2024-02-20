package shamsiddin.project.tourvibe.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.google.gson.Gson
import shamsiddin.project.tourvibe.screen.menu.FoodSectionLayout
import shamsiddin.project.tourvibe.screen.menu.PlaceItem
import uz.asilbek.tour_menu.Food
import uz.asilbek.tour_menu.FoodArgType
import uz.asilbek.tour_menu.menu.FoodExtendedInformation
import kotlin.math.log

//import shamsiddin.project.tourvibe.screen.menu.Menu


@Composable
fun SetNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = ScreenType.FoodSection.route) {
        composable(ScreenType.FoodSection.route) {
            FoodSectionLayout(navController)
        }

        composable(ScreenType.FoodExtendedInformation.route, arguments = listOf(navArgument("food"){
            type = FoodArgType()
        })){
            val food =it.arguments?.getString("food")?.let { it1 -> Gson().fromJson(it1, Food::class.java) }
            FoodExtendedInformation(navController = navController, food = food!!)
            Log.d("shmas aqlli", "SetNavGraph: ${food!!.name}")
        }


    }
}