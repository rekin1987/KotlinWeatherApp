package pl.emget.kotlinweatherapp.ui

import android.app.Application

class App : Application(){

    //companion object{
//        lateinit var instance: App
        var instance: App by NotNullSingleValueVar()
 //   }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }


}