package com.example.demo.adapters.infrastructure.client.rest

import com.example.demo.adapters.infrastructure.configurations.OpenWeatherMapAPI
import com.example.demo.applicationCore.domain.entities.OpenWeatherMap
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import java.net.URI

@Service
class OpenWeatherMapClient(val restTemplate: RestTemplate, val openWeatherMapAPI: OpenWeatherMapAPI) {

    val log: Logger = LoggerFactory.getLogger(this.javaClass)

    companion object {
        const val OPEN_WEATHER_MAP_URL = "http://api.openweathermap.org/data/2.5/weather"
    }

    fun getWeather(cityName: String): OpenWeatherMap? {
        log.info("Getting weather form $cityName")
        val uri = "$OPEN_WEATHER_MAP_URL?q=$cityName&appid=${openWeatherMapAPI.getApiKey()}"
        log.info("Requesting $uri")
        return get(URI.create(uri))
    }

    fun getWeather(lon: Double, lat: Double): OpenWeatherMap? {
        log.info("Getting weather form $lon and $lat")
        val uri = "$OPEN_WEATHER_MAP_URL?lat=$lat&lon=$lon&appid=${openWeatherMapAPI.getApiKey()}"
        log.info("Requesting $uri")
        return get(URI.create(uri))
    }

    private fun get(uri: URI): OpenWeatherMap? = restTemplate.getForObject(uri, OpenWeatherMap::class.java)
}