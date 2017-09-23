package pl.emget.kotlinweatherapp.ui

import android.app.Application
import android.util.Log
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.debug
import org.jetbrains.anko.toast
import kotlin.properties.Delegates

fun android.util.Log.dd(tag: String = "${javaClass.simpleName}", message: String) = Log.d(tag, message)

class App : Application(), AnkoLogger {

    //companion object{
//        lateinit var instance: App
    var instance: App by NotNullSingleValueVar()
    //   }

    override fun onCreate() {
        super.onCreate()
        instance = this
        myProp = "aaa"
        myProp2 = 67
        myProp2 = -99 // this is never assigned because delegate forbids value less than 0
        Log.d("aa", myProp2.toString())
        debug { myProp2 }

    }

    var myProp by Delegates.observable("") { _, _, new ->
        toast(new)
    }

    var myProp2 by Delegates.vetoable(5) { _, _, new ->
        new >= 0
    }

}