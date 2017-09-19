package pl.emget.kotlinweatherapp

import android.util.Log
import java.net.URL

class Request(var url: String){

    fun run(){
        val dataJson = URL(url).readText()
        Log.d(javaClass.simpleName, dataJson)
    }

}