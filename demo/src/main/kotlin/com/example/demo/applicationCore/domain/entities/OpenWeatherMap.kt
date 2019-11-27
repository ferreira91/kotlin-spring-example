package com.example.demo.applicationCore.domain.entities

data class OpenWeatherMap(val main: Main, val sys: Sys)

data class Main(val temp: Double)

data class Sys(val country: String)