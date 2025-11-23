package com.example.a6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CountryCardsTheme(dynamicColor = true, darkTheme = true) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CountryCardsApp()
                }
            }
        }
    }
}

@Composable
fun CountryCardsApp() {
    val countries = listOf(
        Country("Finland", "\uD83C\uDDEB\uD83C\uDDEE"),
        Country("Japan", "\uD83C\uDDEF\uD83C\uDDF5"),
        Country("Brazil", "\uD83C\uDDE7\uD83C\uDDF7"),
        Country("Canada", "\uD83C\uDDE8\uD83C\uDDE6")
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        countries.forEach { country ->
            CountryCard(country)
        }
    }
}

@Composable
fun CountryCard(country: Country) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFBBDEFB)),
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = country.flag,
                fontSize = 48.sp
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = country.name,
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                color = Color.Black
            )
        }
    }
}

data class Country(val name: String, val flag: String)

@Composable
fun CountryCardsTheme(
    dynamicColor: Boolean = true,
    darkTheme: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) darkColorScheme(
        primary = Color(0xFF90CAF9),
        secondary = Color(0xFF64B5F6),
        background = Color(0xFF121212),
        surface = Color(0xFF1E1E1E)
    ) else lightColorScheme(
        primary = Color(0xFF1976D2),
        secondary = Color(0xFF64B5F6),
        background = Color(0xFFFFFFFF),
        surface = Color(0xFFE3F2FD)
    )

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography(),
        content = content
    )
}

