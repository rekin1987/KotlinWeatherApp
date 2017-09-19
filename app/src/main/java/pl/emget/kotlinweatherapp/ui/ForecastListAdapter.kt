package pl.emget.kotlinweatherapp.ui

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView
import pl.emget.kotlinweatherapp.model.ForecastList


class ForecastListAdapter(private val weekForecast: ForecastList) : RecyclerView.Adapter<ForecastListAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(TextView(parent.context))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        with(weekForecast.dailyForecast[position]){
        holder.textView.text = "$date - $description - $high/$low"
        }
    }

    override fun getItemCount(): Int {
        return weekForecast.dailyForecast.size
    }

    class MyViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)
}