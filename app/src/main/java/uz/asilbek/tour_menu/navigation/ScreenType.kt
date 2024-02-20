package shamsiddin.project.tourvibe.navigation

sealed class ScreenType(val route: String){
    object Menu: ScreenType("menu_screen")
    object FoodSection: ScreenType("food_screen")
    object FoodExtendedInformation: ScreenType("food_extended_screen"+"/{food}")
//    object Login: ScreenType("login_screen")
//    object Registration: ScreenType("registration_screen")
//    object Hotels: ScreenType("hotels_screen")
//    object Menu: ScreenType("menu_screen")
//    object GuideBook: ScreenType("guideBook_screen")
//    object Profile: ScreenType("profile_screen")
//    object Countries: ScreenType("countries_screen")
}
