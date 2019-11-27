package com.example.demo.adapters.ui.controllers

import com.example.demo.applicationCore.application.operations.WeatherRecommendationByCityOperation
import com.example.demo.applicationCore.application.operations.WeatherRecommendationByGeographicCoordinatesOperation
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/weather-recommendations/v1")
class WeatherRecommendationController(val weatherRecommendationByCityOperation: WeatherRecommendationByCityOperation,
                                      val weatherRecommendationByGeographicCoordinatesOperation: WeatherRecommendationByGeographicCoordinatesOperation ) {

    @GetMapping("/cities")
    fun getRecommendationByCity(@RequestParam cityName: String) = weatherRecommendationByCityOperation.execute(cityName)

    @GetMapping("/geographic-coordinates")
    fun getRecommendationByWeather(@RequestParam lon: Double, @RequestParam lat: Double) = weatherRecommendationByGeographicCoordinatesOperation.execute(lon, lat)
}