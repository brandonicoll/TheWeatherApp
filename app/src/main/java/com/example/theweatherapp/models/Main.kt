package com.example.theweatherapp.models

import java.io.Serializable

data class Main(
    val temp: Double,
    val pressure: Double,
    val humidity: Int,
    val tempMin: Int,
    val tempMax: Int
) : Serializable
