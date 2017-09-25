package pl.emget.kotlinweatherapp.database

import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.MapRowParser
import org.jetbrains.anko.db.SelectQueryBuilder
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.db.select
import pl.emget.kotlinweatherapp.model.ForecastList
import java.sql.SQLData


class ForecastDb(
        val dataMapper: DbDataMapper = DbDataMapper()) {

    fun requestForecastByZipCode(zip: Long, date: Long) = ForecastDbHelper.instance.use {
        val dailyRequest = "${DayForecastTable.CITY_ID} = ? AND ${DayForecastTable.DATE} = ?"

        val dailyForecast = select(DayForecastTable.NAME).whereSimple(dailyRequest, zip.toString(), date.toString()).parseList { DayForecast(HashMap(it)) }

        val city = select(CityForecastTable.NAME).whereSimple("${CityForecastTable.ID} = ?", zip.toString()).parseOpt { CityForecast(HashMap(it), dailyForecast) }

        if (city != null) dataMapper.convertToDomain(city) else null
    }

    fun saveForecast(forecast: ForecastList) = ForecastDbHelper.instance.use {
        clear(CityForecastTable.NAME)
        clear(DayForecastTable.NAME)

        with(dataMapper.convertFromDomain(forecast)) {
            insert(CityForecastTable.NAME, *map.toVarargArray())
            dailyForecast.forEach { insert(DayForecastTable.NAME, *it.map.toVarargArray()) }
        }

    }


}

fun <T : Any> SelectQueryBuilder.parseList(parser: (Map<String, Any?>) -> T): List<T> =
        parseList(object : MapRowParser<T> {
            override fun parseRow(columns: Map<String, Any?>): T = parser(columns)
        })

fun <T : Any> SelectQueryBuilder.parseOpt(parser: (Map<String, Any?>) -> T): T? =
        parseOpt(object : MapRowParser<T> {
            override fun parseRow(columns: Map<String, Any?>): T = parser(columns)
        })

fun SQLiteDatabase.clear(name: String) {
    execSQL("delete from $name")
}

fun <K, V : Any> MutableMap<K, V?>.toVarargArray(): Array<out Pair<K, V>> = map({ Pair(it.key, it.value!!) }).toTypedArray()