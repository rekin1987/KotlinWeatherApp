package pl.emget.kotlinweatherapp.model

data class Forecast(val date: String, val description: String, val high: Int, val low: Int, val iconUrl: String)

data class ForecastList(val city: String, val country: String, val dailyForecast: List<Forecast>) {
    val size: Int
        get() = dailyForecast.size

    operator fun get(pos: Int) = dailyForecast[pos]

}