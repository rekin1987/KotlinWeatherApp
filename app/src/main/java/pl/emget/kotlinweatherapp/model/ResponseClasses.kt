package pl.emget.kotlinweatherapp.model


data class JsonForecastResult(val city: JsonCity, val list: List<JsonForecast>)
data class JsonCity(val id: Long, val name: String, val coord: JsonCoordinates, val country: String, val population: Int)
data class JsonCoordinates(val lon: Float, val lat: Float)
data class JsonForecast(val dt: Long, val temp: JsonTemperature, val pressure: Float, val humidity: Int,
                        val weather: List<JsonWeather>, val speed: Float, val deg: Int, val clouds: Int, val rain: Float)

data class JsonTemperature(val day: Float, val min: Float, val max: Float, val night: Float, val eve: Float, val morn: Float)
data class JsonWeather(val id: Long, val main: String, val description: String, val icon: String)