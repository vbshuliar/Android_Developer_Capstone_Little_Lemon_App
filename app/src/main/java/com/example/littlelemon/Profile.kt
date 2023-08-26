package com.example.littlelemon

import android.content.Context
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController


@Composable
fun Profile(navController: NavHostController) {
    val context = LocalContext.current
    val sharedPreferences = context.getSharedPreferences("user_data", Context.MODE_PRIVATE)
    val firstName = sharedPreferences.getString("first_name", "First name") ?: "First name"
    val lastName = sharedPreferences.getString("last_name", "Last name") ?: "Last name"
    val email = sharedPreferences.getString("email", "Email") ?: "Email"

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Little Lemon Logo",
            modifier = Modifier
                .padding(bottom = 80.dp, top = 20.dp)
                .height(50.dp)
                .fillMaxWidth()
        )

        Text(
            text = "Personal information",
            modifier = Modifier.padding(vertical = 40.dp, horizontal = 15.dp),
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )



        Text(
            text = "First name",
            modifier = Modifier.padding(vertical = 5.dp, horizontal = 15.dp),
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF4B4C51)
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
                .padding(horizontal = 15.dp)
                .border(1.dp, Color(0xFFC8C8C8), RoundedCornerShape(10.dp)),
            contentAlignment = Alignment.CenterStart
        ) {

            Text(
                text = firstName,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp),
                fontSize = 14.sp,
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Last name",
            modifier = Modifier.padding(vertical = 5.dp, horizontal = 15.dp),
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF4B4C51)
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
                .padding(horizontal = 15.dp)
                .border(1.dp, Color(0xFFC8C8C8), RoundedCornerShape(10.dp)),
            contentAlignment = Alignment.CenterStart
        ) {

            Text(
                text = lastName,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp),
                fontSize = 14.sp,
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Email",
            modifier = Modifier.padding(vertical = 5.dp, horizontal = 15.dp),
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF4B4C51)
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
                .padding(horizontal = 15.dp)
                .border(1.dp, Color(0xFFC8C8C8), RoundedCornerShape(10.dp)),
            contentAlignment = Alignment.CenterStart
        ) {

            Text(
                text = email,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp),
                fontSize = 14.sp,
            )
        }
        Spacer(modifier = Modifier.height(20.dp))





        Spacer(modifier = Modifier.weight(1f))


        Button(
            onClick = {
                sharedPreferences.edit().clear().apply()
                navController.navigate(Onboarding.route)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 30.dp, start = 15.dp, end = 15.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(0xFFF4CE14),
                contentColor = Color(0xFF000000)
            ),
            border = BorderStroke(2.dp, Color(0xFFFFA500)),
            shape = RoundedCornerShape(10.dp)
        ) {
            Text(text = "Log out")
        }
//        }
    }
}

@Preview
@Composable
fun PreviewProfile() {

}
