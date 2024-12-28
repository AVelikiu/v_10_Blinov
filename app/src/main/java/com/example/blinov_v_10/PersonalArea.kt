package com.example.blinov_v_10

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Surface
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.runtime.getValue
import androidx.compose.ui.text.withStyle


@Composable
fun PersonalArea(navController: NavController, username: String) {
    val db = com.google.firebase.firestore.FirebaseFirestore.getInstance()
    var user by remember { mutableStateOf("") }
    var loading by remember { mutableStateOf(true) }
    var errorMessage by remember { mutableStateOf("") }
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        db.collection("users")
            .document(username)
            .get()
            .addOnSuccessListener { document ->
                if (document.exists()) {
                    user = document.getString("username") ?: "Unknown"
                } else {
                    errorMessage = "Пользователь не найден"
                }
                loading = false
            }
            .addOnFailureListener {
                errorMessage = "Ошибка загрузки данных"
                loading = false
            }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            IconButton(onClick = { navController.navigate("login") }) {
                Image(
                    painter = painterResource(R.drawable.exit),
                    contentDescription = "Выход",
                    modifier = Modifier.size(24.dp)
                )
            }

            Text(
                text = "Личный кабинет",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(1f)
            )

            IconButton(onClick = { navController.navigate("statistic") }) {
                Image(
                    painter = painterResource(id = R.drawable.bell),
                    contentDescription = "уведомления",
                    modifier = Modifier.size(24.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(36.dp))

        if (loading) {
            Text("Загрузка...", fontSize = 16.sp, textAlign = TextAlign.Center)
        } else if (errorMessage.isNotEmpty()) {
            Text("Ошибка: $errorMessage", fontSize = 16.sp, color = Color.Red)
        } else {
            Text(
                text = buildAnnotatedString {
                    append("Привет, ")
                    withStyle(style = androidx.compose.ui.text.SpanStyle(color = Color.Green)) {
                        append("$user")
                    }
                    append("!")
                },
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(25.dp))

        Text("Вы забронировали билеты", fontSize = 16.sp)

        Spacer(modifier = Modifier.height(4.dp))

        Text("OVB — MOW", fontSize = 26.sp,  fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = buildAnnotatedString {
                append("Оплатите до ")
                withStyle(style = androidx.compose.ui.text.SpanStyle(color = Color.Green)) {
                    append("22 декабря, в 11:20")
                }
            },
                fontSize = 16.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.aviasales.ru"))
                context.startActivity(intent)
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF58BA0B),
                contentColor = Color.White
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            shape = RoundedCornerShape(16.dp),
        ) {
            Text("Оплатить через сайт", fontSize = 16.sp, fontWeight = FontWeight.Bold)
        }
        Spacer(modifier = Modifier.height(8.dp))

        Image(
            painter = painterResource(R.drawable.news1),
            contentDescription = "Map Preview",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(8.dp)
        )
    }
}



