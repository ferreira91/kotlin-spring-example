package com.example.demo.applicationCore.application.operations

import com.example.demo.adapters.infrastructure.client.rest.OpenWeatherMapClient
import com.example.demo.applicationCore.application.services.TemperatureRecommendationService
import com.wrapper.spotify.model_objects.specification.Recommendations
import org.springframework.stereotype.Service

@Service
class WeatherRecommendationByGeographicCoordinatesOperation(val openWeatherMapClient: OpenWeatherMapClient,
                                                            val temperatureRecommendationService: TemperatureRecommendationService) {

    fun execute(lon: Double, lat: Double): Recommendations? {
        val openWeatherMap = openWeatherMapClient.getWeather(lon, lat)
        return temperatureRecommendationService.getRecommendation(openWeatherMap)
    }
}