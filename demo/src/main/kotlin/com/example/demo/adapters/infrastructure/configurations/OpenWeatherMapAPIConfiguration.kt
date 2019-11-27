package com.example.demo.adapters.infrastructure.configurations

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class OpenWeatherMapAPIConfiguration {

    val log: Logger = LoggerFactory.getLogger(this.javaClass)

    @Bean
    fun createOpenWeatherMapAPI(@Value("\${openweathermap.api-key}") apiKey: String): OpenWeatherMapAPI {
        log.info("Creating OpenWeatherMapApi...")
        return OpenWeatherMapAPI(apiKey)
    }
}   