package com.example.demo.applicationCore.application.operations

import com.example.demo.adapters.infrastructure.client.rest.OpenWeatherMapClient
import com.example.demo.applicationCore.application.services.TemperatureRecommendationService
import org.springframework.stereotype.Service

@Service
class WeatherRecommendationByGeographicCoordinatesOperation(val openWeatherMapClient: OpenWeatherMapClient,
                                                            val temperatureRecommendationService: TemperatureRecommendationService) {

    fun execute(lon: Double, lat: Double): List<String> {
        val openWeatherMap = openWeatherMapClient.getWeather(lon, lat)
        return temperatureRecommendationService.getRecommendations(openWeatherMap)
    }
}