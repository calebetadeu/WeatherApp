package com.example.weatherapp.screens

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import com.example.weatherapp.R
import com.example.weatherapp.remember.rememberLifecycleEvent
import kotlinx.coroutines.delay

@Composable
fun WeatherSplashScreen(onNavigateToHomeScreen: () -> Unit) {
        val scale = remember {
                Animatable(0f)
        }
        val lifeCycleEvent = rememberLifecycleEvent()
        LaunchedEffect(lifeCycleEvent) {
                if (lifeCycleEvent == Lifecycle.Event.ON_RESUME) {
                        scale.animateTo(targetValue = 0.9f,
                                animationSpec = tween(
                                        durationMillis = 800,
                                        easing = {
                                                OvershootInterpolator(8f)
                                                        .getInterpolation(it)
                                        }
                                ))
                }
                delay(2000L)
                onNavigateToHomeScreen()
        }
        Surface(
                modifier = Modifier
                        .padding(15.dp)
                        .size(330.dp)
                        .scale(scale.value),
                shape = CircleShape,
                color = Color.White,
                border = BorderStroke(width = 2.dp, color = Color.LightGray),

                ) {
                Column(
                        modifier = Modifier.padding(1.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                ) {
                        Image(
                                painter = painterResource(id = R.drawable.sun),
                                contentDescription = "Sun",
                                contentScale = ContentScale.Fit,
                                modifier = Modifier.size(95.dp)
                        )


                }

        }
}

@Preview(showBackground = true)
@Composable
fun PreviewWeatherSplashScreen() {
        WeatherSplashScreen({})
}