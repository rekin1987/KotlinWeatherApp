package pl.emget.kotlinweatherapp.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.find
import org.jetbrains.anko.uiThread
import pl.emget.kotlinweatherapp.R
import pl.emget.kotlinweatherapp.model.RequestForecastCommand

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val forecastList: RecyclerView = find(R.id.forecast_list)
        forecastList.layoutManager = LinearLayoutManager(this)


        doAsync {
            val appModel = RequestForecastCommand("94043").execute()
            uiThread { forecastList.adapter = ForecastListAdapter(appModel) }
        }
    }
}
