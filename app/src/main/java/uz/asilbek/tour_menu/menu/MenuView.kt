package shamsiddin.project.tourvibe.screen.menu


import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.SubcomposeAsyncImage
import uz.asilbek.tour_menu.Food
import uz.asilbek.tour_menu.R
import uz.asilbek.tour_menu.ui.theme.BACKGROUNDCARD
import uz.asilbek.tour_menu.ui.theme.PurpleGrey40

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FoodSectionLayout(navController: NavController) {
    var search = ""
    var foodlist = mutableListOf<Food>()
    val focusRequester = remember { FocusRequester() }
    var food = Food(
        0,
        "https://www.shutterstock.com/image-photo/burger-tomateoes-lettuce-pickles-on-600nw-2309539129.jpg",
        listOf("", "", ""),
        "burger",
        "thu is burger",
        4.7,
        null,
        "fast food",
        "Everywhere",
        "Uzb"
    )

    var food1 = Food(
        0,
        "https://t3.ftcdn.net/jpg/03/09/85/36/360_F_309853648_yJJrVCYncv1D4raXzSH39WUlrRMLEwv3.jpg",
        listOf("", "", ""),
        "lavash",
        "thu is burger",
        4.7,
        null,
        "fast food",
        "Everywhere",
        "Uzb"
    )
    foodlist.add(food)
    foodlist.add(food1)

    Column {


        Scaffold(

        )

        {
            Spacer(modifier = Modifier.height(32.dp))
            Column(
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 24.dp)
            ) {

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly

                ) {
                    IconButton(onClick = { /* Handle settings click */ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.person),
                            modifier = Modifier.size(32.dp),
                            contentDescription = "Person",
                        )
                    }
                    Column {
                        Text(
                            text = "    Hello username",
                            color = Color.Gray,
                            modifier = Modifier.padding(start = 4.dp),

                            )

                        Row {
                            Icon(
                                painter = painterResource(id = R.drawable.location),
                                modifier = Modifier.size(28.dp),

                                contentDescription = "location",
                            )
//                            Spacer(modifier = Modifier.height(3.dp))
                            Text(
                                text = "state, country ",
                                color = Color.Black,
                                fontSize = 17.sp,
                                modifier = Modifier.padding(start = 4.dp, top = 5.dp),

                                )
                        }
                    }


                    IconButton(onClick = { /* Handle settings click */ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.settings),
                            modifier = Modifier.size(32.dp),
                            contentDescription = "Settings"
                        )
                    }
                }







                Spacer(modifier = Modifier.height(16.dp))
                // Search Bar and Filter Icon

                TextField(
                    value = search,
                    modifier = Modifier
                        .fillMaxWidth()
                        .focusRequester(focusRequester = focusRequester),
                    onValueChange = {
                        search = it
                    },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    shape = RoundedCornerShape(16.dp),
                    placeholder = {
                        Text(text = "Search", fontSize = 14.sp)
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Search,
                            contentDescription = "",
                            tint = Color.Black
                        )
                    },
                    colors = TextFieldDefaults.textFieldColors(
//                textColor = Text2,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
//                cursorColor = Text2,
//                containerColor = Secondary
                    ),
                    textStyle = TextStyle(fontSize = 16.sp),
                )


                Spacer(modifier = Modifier.height(8.dp))
                // Lazy Column Content
                LazyColumn(
                    Modifier
                        .fillMaxHeight()
                        .padding(start = 5.dp, end = 5.dp)
                ) {

                    items(foodlist) { foodItem ->
                        PlaceItem(foodItem,navController)

                    }
                }
            }
        }
    }
}


@Composable
fun PlaceItem(destination: Food,navController:NavController) {
    Spacer(modifier = Modifier.height(8.dp))
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(210.dp)
            .aspectRatio(1.8f).clickable {
                navController.navigate("food_extended_screen" + "/${destination}")
            },
        shape = RoundedCornerShape(30.dp),

        elevation = CardDefaults.cardElevation(5.dp) // CardDefaults.cardElevation is deprecated, you can directly use dp values
    ) {
        Box(modifier = Modifier.fillMaxHeight()) {
            SubcomposeAsyncImage(
                model = destination.mainImage,
                contentDescription = "",
                modifier = Modifier
                    .fillMaxHeight(),
                contentScale = ContentScale.Crop,
                loading = { CircularProgressIndicator() }
            )
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 15.dp, end = 15.dp, bottom = 15.dp)
                    .align(Alignment.BottomCenter),
                colors = CardDefaults.cardColors(BACKGROUNDCARD),
                elevation = CardDefaults.cardElevation(5.dp)// Same as above
            ) {
                Row(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween) {


                    Column {
                        Text(
                            color = Color.White,
                            modifier = Modifier.padding(start = 20.dp),
                            text = destination.name,
                            fontWeight = FontWeight.Bold,
                            fontSize = 17.sp
                        )

                        Text(
                            color = Color.White,
                            modifier = Modifier.padding(start = 20.dp, top = 5.dp),
                            text = destination.name,
                            fontWeight = FontWeight.Bold,
                            fontSize = 17.sp
                        )
                    }
                    Text(
                        color = Color.White,
                        text = destination.name,
                        modifier = Modifier.padding(end = 20.dp),
                        fontWeight = FontWeight.Bold,
                        fontSize = 17.sp)
                }
            }
        }
    }
}


//@Composable
//fun Menu(navController: NavController) {
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(Color.White)
//            .verticalScroll(
//                rememberScrollState()
//            ),
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(10.dp), verticalAlignment = Alignment.CenterVertically
//        ) {
//            Image(
//                painter = painterResource(id = R.drawable.person_default_ic),
//                contentDescription = "",
//                modifier = Modifier
//                    .size(70.dp).padding(10.dp)
//                    .clip(
//                        RoundedCornerShape(50)
//                    )
//            )
//            Spacer(modifier = Modifier.width(10.dp))
//            Column(horizontalAlignment = Alignment.CenterHorizontally) {
//
//                Text(text = "Hello"+" name", fontSize = 15.sp)
//            }
//
//            Image(
//                painter = painterResource(id = R.drawable.settings
//                ),
//                contentDescription = "",
//                modifier = Modifier
//                    .size(50.dp).padding(10.dp)
//                    .clip(
//                        RoundedCornerShape(50)
//                    )
//            )
//        }
//    }
//}