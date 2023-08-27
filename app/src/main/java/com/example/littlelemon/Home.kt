package com.example.littlelemon

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun Home(navController: NavHostController, database: AppDatabase) {

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 80.dp, top = 20.dp),
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
        Spacer(modifier = Modifier.weight(0.5f))
        HeroSection(database)


    }
}

@Composable
fun HeroSection(database: AppDatabase) {
    val databaseMenuItems by database.menuItemDao().getAll().observeAsState(emptyList())
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(500.dp)
            .background(Color(0xFF4C5E57))
            .padding(horizontal = 16.dp, vertical = 24.dp),
    ) {
        Text(
            text = "Little Lemon",
            color = Color.Yellow,
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Chicago", color = Color.Gray, fontSize = 16.sp
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "We are a family-owned Mediterranean restaurant, focused on traditional recipes served with a modern twist",
            color = Color.Black,
            fontSize = 16.sp
        )

    }
    Text(text = databaseMenuItems.toString())

}



