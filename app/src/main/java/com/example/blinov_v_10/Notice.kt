package com.example.blinov_v_10

import android.os.Bundle
import android.view.Surface
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.compose.runtime.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.IconButton
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController

@Composable
fun Notice(navController: NavController) {

    var notification by remember { mutableStateOf(true) }
    var conditions by remember { mutableStateOf(false) }
    var flights by remember { mutableStateOf(false) }

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

            IconButton(onClick = { navController.popBackStack() }) {
                Image(
                    painter = painterResource(id = R.drawable.back),
                    contentDescription = "Назад",
                    modifier = Modifier.size(24.dp)
                )
            }

            Text(
                text = "Уведомления",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(1f)
            )
            IconButton(onClick = { navController.navigate("statistic") }) {
                Image(
                    painter = painterResource(id = R.drawable.bell),
                    contentDescription = "уведомления",
                    modifier = Modifier
                        .size(24.dp)
                        .alpha(0f)
                )
            }
        }

            Spacer(modifier = Modifier.height(26.dp))

            Text("Оплатите билеты до 22 декабря, в 11:20", fontSize = 20.sp)
            Spacer(modifier = Modifier.height(26.dp))

            Text("Заканчивается время бронирования билетов", fontSize = 20.sp)
            Spacer(modifier = Modifier.height(26.dp))

            Text("Вы успешно забронировали билеты на самолет", fontSize = 20.sp)

            Spacer(modifier = Modifier.height(100.dp))




            Row {
                Text("Включить уведомления")

                Checkbox(
                    checked = notification,
                    onCheckedChange = { notification = it },
                    colors = CheckboxDefaults.colors(checkedColor = Color(0xFF58BA0B))
                )
            }
            Spacer(modifier = Modifier.height(15.dp))

            Row {
                Text("Предлагать выгодные условия")

                Checkbox(
                    checked = conditions,
                    onCheckedChange = { conditions = it },
                    colors = CheckboxDefaults.colors(checkedColor = Color(0xFF58BA0B))
                )
            }
            Spacer(modifier = Modifier.height(15.dp))

            Row {
                Text("Показывать только прямые перелеты")

                Checkbox(
                    checked = flights,
                    onCheckedChange = { flights = it },
                    colors = CheckboxDefaults.colors(checkedColor = Color(0xFF58BA0B))
                )
            }
        }
    }





