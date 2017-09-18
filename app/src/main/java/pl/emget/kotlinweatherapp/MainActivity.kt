package pl.emget.kotlinweatherapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val itemsList = listOf("Mon - Sunny", "Tue - Foggy", "Wed - Cloudy", "Thu - Rain all day", "Fri - Foggy", "Sat - TRAPPED IN WEATHERSTATION", "Sun - Sunny")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val forecastList = findViewById<RecyclerView>(R.id.forecast_list)
        forecastList.layoutManager = LinearLayoutManager(this)
        forecastList.adapter = ForecastListAdapter(itemsList)
    }
}
