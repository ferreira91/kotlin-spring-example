package com.example.demo.applicationCore.application.operations

import com.example.demo.adapters.infrastructure.client.rest.OpenWeatherMapClient
import com.example.demo.applicationCore.application.services.TemperatureRecommendationService
import org.springframework.stereotype.Service

@Service
class WeatherRecommendationByCityOperation(val openWeatherMapClient: OpenWeatherMapClient,
                                           val temperatureRecommendationService: TemperatureRecommendationService) {
    fun execute(cityName: String): List<String> {
        val openWeatherMap = openWeatherMapClient.getWeather(cityName)
        return temperatureRecommendationService.getRecommendations(openWeatherMap)
    }
}