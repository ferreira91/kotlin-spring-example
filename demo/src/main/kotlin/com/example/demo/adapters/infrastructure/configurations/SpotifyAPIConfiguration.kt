package com.example.demo.adapters.infrastructure.configurations

import com.wrapper.spotify.SpotifyApi
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SpotifyAPIConfiguration {

    val log: Logger = LoggerFactory.getLogger(this.javaClass)

    @Bean
    fun createApi(
            @Value("\${spotify.client-id}") clientId: String,
            @Value("\${spotify.client-secret}") clientSecret: String
    ): SpotifyApi {
        log.info("Creating SpotifyApi...")
        val spotifyApi = SpotifyApi.Builder()
                .setClientId(clientId)
                .setClientSecret(clientSecret)
                .build()

        val clientCredentialsRequest = spotifyApi.clientCredentials().build()
        val clientCredentials = clientCredentialsRequest.execute()
        spotifyApi.accessToken = clientCredentials.accessToken
        log.info("Access token ${clientCredentials.accessToken} expires in ${clientCredentials.expiresIn}(s)")

        return spotifyApi
    }

}