package com.example.demo.applicationCore.application.operations

import com.example.demo.adapters.infrastructure.client.rest.OpenWeatherMapClient
import com.example.demo.applicationCore.application.services.TemperatureRecommendationService
import com.wrapper.spotify.model_objects.specification.Recommendations
import org.springframework.stereotype.Service

@Service
class WeatherRecommendationByCityOperation(val openWeatherMapClient: OpenWeatherMapClient,
                                           val temperatureRecommendationService: TemperatureRecommendationService) {
    fun execute(cityName: String): Recommendations? {
        val openWeatherMap = openWeatherMapClient.getWeather(cityName)
        return temperatureRecommendationService.getRecommendation(openWeatherMap)
    }
}