Micro-service RESTful requests receiving as parameter either city name or lat long coordinates and returns a playlist suggestion according to the current temperature.

GET - http://localhost:8080/weather-recommendations/v1/cities?cityName={cityName}
GET - http://localhost:8080/weather-recommendations/v1/geographic-coordinates?lon={lon}&lat={lat}
