package com.example.littlelemon

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Onboarding() {
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Little Lemon Logo",
            modifier = Modifier
                .padding(20.dp)
                .height(50.dp)
                .fillMaxWidth()
        )

        Text(
            text = "Let's get to know you",
            modifier = Modifier
                .background(color = Color(0xFF495E57))
                .padding(50.dp)
                .fillMaxWidth(),
            fontSize = 22.sp,
            color = Color(0xFFFFFFFF),
            textAlign = TextAlign.Center
        )

        Text(
            text = "Personal information",
            modifier = Modifier.padding(vertical = 40.dp, horizontal = 15.dp),
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )

        OutlinedTextField(
            value = firstName,
            onValueChange = { firstName = it },
            label = { Text(text = "First name") },
            modifier = Modifier
                .padding(horizontal = 15.dp, vertical = 5.dp)

                .fillMaxWidth()
        )

        OutlinedTextField(
            value = lastName,
            onValueChange = { lastName = it },
            label = { Text(text = "Last name") },
            modifier = Modifier
                .padding(horizontal = 15.dp, vertical = 5.dp)

                .fillMaxWidth()
        )

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text(text = "Email") },
            modifier = Modifier
                .padding(horizontal = 15.dp, vertical = 5.dp)
                .fillMaxWidth()
        )

        Button(
            onClick = { /* TODO */ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp)
                .align(Alignment.BottomCenter),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFF4CE14),
                contentColor = Color(0xFF000000)
            )
        ) {
            Text(text = "Register")
        }
    }
}

@Preview
@Composable
fun OnboardingPreview() {
    Onboarding()
}
