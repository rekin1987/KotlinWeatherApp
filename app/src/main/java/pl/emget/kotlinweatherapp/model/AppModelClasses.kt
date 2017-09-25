package pl.emget.kotlinweatherapp.model

data class Forecast(val date: Long, val description: String, val high: Int, val low: Int, val iconUrl: String)

data class ForecastList(val id: Long, val city: String, val country: String, val dailyForecast: List<Forecast>) {
    val size: Int
        get() = dailyForecast.size

    operator fun get(pos: Int) = dailyForecast[pos]

}