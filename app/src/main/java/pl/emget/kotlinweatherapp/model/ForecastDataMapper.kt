package pl.emget.kotlinweatherapp.model

import java.text.DateFormat
import java.util.*
import java.util.concurrent.TimeUnit

/**
 * Maps JSON model to app model.
 */
class ForecastDataMapper {

    fun mapToAppModel(forecastResult: JsonForecastResult) : ForecastList {
        return ForecastList(forecastResult.city.name, forecastResult.city.country, convertForecastListToAppModel(forecastResult.list))
    }

    private fun convertForecastListToAppModel(list: List<JsonForecast>) : List<Forecast> {
        return list.mapIndexed { i, forecast ->
            val time = Calendar.getInstance().timeInMillis + TimeUnit.DAYS.toMillis(i.toLong())
            convertForecastToAppModel(forecast.copy(dt = time))
        }
    }

    private fun convertForecastToAppModel(jsonForecast: JsonForecast) : Forecast {
        return Forecast(convertDate(jsonForecast.dt), jsonForecast.weather[0].description, jsonForecast.temp.max.toInt(), jsonForecast.temp.min.toInt())
    }

    private fun convertDate(date: Long) : String{
        val df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault())
        return df.format(date)
    }

}