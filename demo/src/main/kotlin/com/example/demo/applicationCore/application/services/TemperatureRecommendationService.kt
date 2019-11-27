package com.example.demo.applicationCore.application.services

import com.example.demo.applicationCore.domain.entities.OpenWeatherMap
import com.neovisionaries.i18n.CountryCode
import com.wrapper.spotify.SpotifyApi
import com.wrapper.spotify.model_objects.specification.Recommendations
import org.springframework.stereotype.Service

@Service
class TemperatureRecommendationService(private val spotifyApi: SpotifyApi) {

    companion object {
        const val PLAYLIST_SIZE = 10
    }

    fun getRecommendation(openWeatherMap: OpenWeatherMap?): Recommendations? {

        val temperatureCelsius = openWeatherMap?.main?.temp?.let { convertKelvinToCelsius(it) }
        val countryCode = CountryCode.getByCode(openWeatherMap?.sys?.country)
        val genre = temperatureCelsius?.let { getGenreByCelsiusTemperature(it) }
        return spotifyApi
                .recommendations
                .limit(PLAYLIST_SIZE)
                .market(countryCode)
                .seed_genres(genre)
                .build()
                .execute()
    }

    private fun convertKelvinToCelsius(temperature: Double) = temperature - 273.15

    private fun getGenreByCelsiusTemperature(temperature: Double) = when (temperature) {
        in 10.0..14.0 -> "rock"
        in 15.0..30.0 -> "pop"
        in 30.0..Double.MAX_VALUE -> "party"
        else -> "classical"
    }
}