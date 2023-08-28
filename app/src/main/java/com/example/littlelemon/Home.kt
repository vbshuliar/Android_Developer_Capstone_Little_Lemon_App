package com.example.littlelemon

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter

@Composable
fun Home(navController: NavHostController, database: AppDatabase) {
    val menuItemsDatabase by database.menuItemDao().getAll().observeAsState(emptyList())

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 20.dp),
            horizontalArrangement = Arrangement.End
        ) {
            Spacer(modifier = Modifier.weight(0.5f))
            Spacer(modifier = Modifier.width(50.dp))
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Little Lemon Logo",
                modifier = Modifier
                    .height(50.dp)
                    .width(200.dp)
            )
            Spacer(modifier = Modifier.weight(0.5f))
            Image(
                painter = painterResource(id = R.drawable.profile),
                contentDescription = "Profile picture",
                modifier = Modifier
                    .padding(end = 15.dp)
                    .size(50.dp)
                    .clip(CircleShape)
                    .clickable { navController.navigate(Profile.route) },
            )
        }
        HeroSection(menuItemsDatabase)


    }
}

@Composable
fun HeroSection(menuItemsDatabase: List<MenuItemRoom>) {
    var menuItems = menuItemsDatabase
    var selectedCategory by remember { mutableStateOf("") }


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF4C5E57))
            .padding(16.dp),
    ) {
        Text(
            text = "Little Lemon",
            color = Color(0xFFEECF00),
            fontSize = 45.sp,
            fontWeight = FontWeight.SemiBold
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp)
        ) {
            Column(modifier = Modifier.weight(0.6f)) {
                Text(
                    text = "Chicago", color = Color.White, fontSize = 30.sp
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "We are a family-owned Mediterranean restaurant, focused on traditional recipes served with a modern twist",
                    color = Color.White,
                    fontSize = 16.sp,
                    lineHeight = 20.sp,
                    fontWeight = FontWeight.Normal
                )
            }

            Image(
                painter = painterResource(id = R.drawable.hero_image),
                contentDescription = "Sandwich",
                modifier = Modifier
                    .size(150.dp)
                    .clip(RoundedCornerShape(10.dp)),
                contentScale = ContentScale.Crop,
            )


        }
        var searchPhrase by remember {
            mutableStateOf("")
        }



        TextField(
            label = { Text(text = "Enter search phrase") },
            value = searchPhrase,
            onValueChange = {
                searchPhrase = it
            },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(Color(0xFFEAEAEA)),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor = Color.Black,
            ),
            leadingIcon = {
                Icon(
                    Icons.Default.Search, contentDescription = null, tint = Color.Black
                )
            },
        )
        if (searchPhrase.isNotEmpty()) {
            menuItems =
                menuItemsDatabase.filter { it.title.contains(searchPhrase, ignoreCase = true) }
        }


    }
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        Text(
            text = "ORDER FOR DELIVERY!",
            modifier = Modifier.padding(top = 30.dp),
            fontWeight = FontWeight.ExtraBold,
            fontSize = 18.sp
        )
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp, bottom = 10.dp)
        ) {
            Button(
                onClick = {
                    selectedCategory = "starters"
                }, modifier = Modifier.height(40.dp), colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(0xFFEDEFEE)
                ), shape = RoundedCornerShape(15.dp)
            ) {
                Text(text = "Starters", fontWeight = FontWeight.Bold, color = Color(0xFF4C5E57))
            }

            Button(
                onClick = {
                    selectedCategory = "mains"
                }, modifier = Modifier.height(40.dp), colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(0xFFEDEFEE)
                ), shape = RoundedCornerShape(15.dp)
            ) {
                Text(text = "Mains", fontWeight = FontWeight.Bold, color = Color(0xFF4C5E57))
            }

            Button(
                onClick = {
                    selectedCategory = "desserts"
                }, modifier = Modifier.height(40.dp), colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(0xFFEDEFEE)
                ), shape = RoundedCornerShape(15.dp)
            ) {
                Text(text = "Desserts", fontWeight = FontWeight.Bold, color = Color(0xFF4C5E57))
            }

            Button(
                onClick = {
                    selectedCategory = "drinks"
                }, modifier = Modifier.height(40.dp), colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(0xFFEDEFEE)
                ), shape = RoundedCornerShape(15.dp)
            ) {
                Text(text = "Drinks", fontWeight = FontWeight.Bold, color = Color(0xFF4C5E57))
            }
        }
    }
    if (selectedCategory.isNotEmpty()) {
        menuItems = menuItems.filter { it.category.contains(selectedCategory) }
    }
    MenuItems(menuItemsList = menuItems)
}


@Composable
fun MenuItems(menuItemsList: List<MenuItemRoom>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxHeight()
            .padding(16.dp)
    ) {
        items(items = menuItemsList, itemContent = { menuItem -> MenuItem(menuItem) })
    }
}


@Composable
fun MenuItem(menuItem: MenuItemRoom) {
    Divider(
        thickness = 2.dp, color = Color(0xFFDDDDDD), modifier = Modifier.padding(vertical = 15.dp)
    )
    Column(verticalArrangement = Arrangement.SpaceBetween) {
        Text(text = menuItem.title, fontWeight = FontWeight.Bold, fontSize = 15.sp)
        Row(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .weight(0.5f)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = menuItem.description, fontSize = 13.sp, color = Color.Gray)
                Text(
                    text = "$${menuItem.price}",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 15.sp,
                    color = Color.Gray
                )
            }
            Image(
                painter = rememberAsyncImagePainter(menuItem.image),
                modifier = Modifier
                    .padding(start = 15.dp)
                    .size(100.dp),
                contentScale = ContentScale.Crop,
                contentDescription = null,
            )
        }
    }


}
