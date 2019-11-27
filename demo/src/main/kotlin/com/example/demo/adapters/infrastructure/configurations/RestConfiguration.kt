package com.example.demo.adapters.infrastructure.configurations

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate

@Configuration
class RestConfiguration {
    @Bean
    fun restTemplate(): RestTemplate = RestTemplate()
}