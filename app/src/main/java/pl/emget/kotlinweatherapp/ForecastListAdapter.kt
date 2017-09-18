package pl.emget.kotlinweatherapp

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView


class ForecastListAdapter(private val items: List<String>) : RecyclerView.Adapter<ForecastListAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(TextView(parent.context))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.textView.text = items[position]
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class MyViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)
}