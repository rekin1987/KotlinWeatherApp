package pl.emget.kotlinweatherapp.ui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import org.jetbrains.anko.find
import pl.emget.kotlinweatherapp.R
import pl.emget.kotlinweatherapp.model.Forecast
import pl.emget.kotlinweatherapp.model.ForecastList


class ForecastListAdapter(private val weekForecast: ForecastList, val itemClick: OnItemClickListener) : RecyclerView.Adapter<ForecastListAdapter.MyViewHolder>() {

    interface OnItemClickListener {
        operator fun invoke(forecast: Forecast)
    }

    class MyViewHolder(view: View, val itemClick: OnItemClickListener) : RecyclerView.ViewHolder(view) {
        private val iconView = view.find<ImageView>(R.id.icon)
        private val dateView = view.find<TextView>(R.id.date)
        private val descView = view.find<TextView>(R.id.description)
        private val maxTempView = view.find<TextView>(R.id.maxTemperature)
        private val minTempView = view.find<TextView>(R.id.minTemperature)

        fun bindForecast(forecast: Forecast) {
            with(forecast) {
                Picasso.with(itemView.context).load(iconUrl).into(iconView)
                dateView.text = date
                descView.text = description
                maxTempView.text = high.toString()
                minTempView.text = low.toString()
                itemView.setOnClickListener { itemClick(this) }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_forecast, parent, false)
        return MyViewHolder(v, itemClick)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindForecast(weekForecast[position])
    }

    override fun getItemCount() = weekForecast.size
}



