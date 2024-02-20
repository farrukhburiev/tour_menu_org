package uz.asilbek.tour_menu.menu

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.SubcomposeAsyncImage
import uz.asilbek.tour_menu.Food


@Composable
fun FoodExtendedInformation(navController: NavController, food: Food) {
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Top) {


//        Spacer(modifier = Modifier.height(8.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(210.dp)
                .aspectRatio(1.8f),


            elevation = CardDefaults.cardElevation(5.dp)
        ) {
            Box(modifier = Modifier.fillMaxHeight()) {
                SubcomposeAsyncImage(
                    model = food.mainImage,
                    contentDescription = "",
                    modifier = Modifier
                        .fillMaxHeight(),
                    contentScale = ContentScale.Crop,
                    loading = { CircularProgressIndicator() }
                )
            }
        }
    }
}
//
//@Composable
//fun MyScreenContent() {
//    Box(modifier = Modifier.fillMaxSize()) {
//        Text(
//            text = "Main Content",
//            modifier = Modifier.align(Alignment.Center)
//
//            )
//    }
//}
//
//@Preview
//@Composable
//fun PreviewCollapsingToolbar() {
//
//    CollapsingToolbar(
//        mainContent = { MyScreenContent() },
//        collapsedTitle = "Collapsed Title",
//        toolbarHeight = 200.dp,
//        scrollOffset = 100.dp
//    )
//
//
//}

//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun CollapsingToolbar(
//    mainContent: @Composable() () -> Unit,
//    collapsedTitle: String,
//    toolbarHeight: Dp,
//    scrollOffset: Dp
//) {
//    Column {
//        // Main content
//        mainContent()
//
//        // Collapsing toolbar
//        Box(
//            modifier = Modifier
//                .height(toolbarHeight - scrollOffset)
//                .padding(bottom = 8.dp)
//        ) {
//            TopAppBar(
//                title = { Text(text = "Collapsing Toolbar") },
//                modifier = Modifier
//                    .height(toolbarHeight).offset(y = scrollOffset).background(Color.Transparent)
//
//            )
//            Text(
//                text = collapsedTitle,
//                textAlign = TextAlign.Center,
//
//                color = Color.White,
//                modifier = Modifier.align(Alignment.BottomCenter)
//            )
//        }
//    }
//}