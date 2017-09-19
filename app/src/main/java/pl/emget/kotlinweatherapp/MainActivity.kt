package pl.emget.kotlinweatherapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.find
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {

    private val itemsList = listOf("Mon - Sunny", "Tue - Foggy", "Wed - Cloudy", "Thu - Rain all day", "Fri - Foggy", "Sat - TRAPPED IN WEATHERSTATION", "Sun - Sunny")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val forecastList: RecyclerView  = find(R.id.forecast_list)
        forecastList.layoutManager = LinearLayoutManager(this)
        forecastList.adapter = ForecastListAdapter(itemsList)

        doAsync {
            val result = Request("94043").run()
            uiThread { toast("Request completed")}
        }
    }
}
