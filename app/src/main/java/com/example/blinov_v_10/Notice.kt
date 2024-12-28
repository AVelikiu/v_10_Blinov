package com.example.blinov_v_10

import androidx.compose.runtime.R
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController

@Composable
fun Notice(navController: NavController) {

    var showTips by remember { mutableStateOf(true) }
    var trackNewOrders by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = androidx.compose.ui.Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {

            IconButton(onClick = { navController.popBackStack() }) {
                Image(
                    painter = painterResource(id = R.drawable.back),
                    contentDescription = "Назад",
                    modifier = Modifier.size(24.dp)
                )
            }

            Text(
                text = "Статистика",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp),
                textAlign = TextAlign.Center
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text("За сегодня вы заработали:", fontSize = 16.sp)
        Text("12 860 руб.", style = MaterialTheme.typography.labelLarge)
        Spacer(modifier = Modifier.height(16.dp))

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Column {
                Text("Выполнено поездок")
                Text("48", style = MaterialTheme.typography.titleLarge)
            }
            Column {
                Text("Средняя оценка")
                Text("4.5", style = MaterialTheme.typography.titleLarge, color = Color.Green)
            }
        }
        Spacer(modifier = Modifier.height(16.dp))

        Text("Настройки статистики")

        // Здесь изменен цвет галочки
        Row {
            Checkbox(
                checked = showTips,
                onCheckedChange = { showTips = it },
                colors = CheckboxDefaults.colors(checkedColor = Color(0xFFFFC727)) // Цвет галочки
            )
            Text("Показывать начисленные чаевые")
        }
        Spacer(modifier = Modifier.height(8.dp))

        Row {
            Checkbox(
                checked = showTips,
                onCheckedChange = { showTips = it },
                colors = CheckboxDefaults.colors(checkedColor = Color(0xFFFFC727)) // Цвет галочки
            )
            Text("Показывать начисленные чаевые")
        }
        Spacer(modifier = Modifier.height(8.dp))

        Row {
            Checkbox(
                checked = trackNewOrders,
                onCheckedChange = { trackNewOrders = it },
                colors = CheckboxDefaults.colors(checkedColor = Color(0xFFFFC727)) // Цвет галочки
            )
            Text("Вести статистику новых заказов")
        }
    }
}





