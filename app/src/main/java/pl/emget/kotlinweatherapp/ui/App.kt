package pl.emget.kotlinweatherapp.ui

import android.app.Application
import android.util.Log
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.debug
import org.jetbrains.anko.info
import org.jetbrains.anko.toast
import kotlin.properties.Delegates

fun Any.dd(message: String, tag: String = "${this.javaClass.simpleName}") = Log.d(tag, message)

class App : Application(), AnkoLogger {

    companion object {
        //        lateinit var instance: App
        var instance: App by NotNullSingleValueVar()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        myProp = "aaa"
        myProp2 = 67
        myProp2 = -99 // this is never assigned because delegate forbids value less than 0
        Log.d("aa", myProp2.toString())
        /*
        ANKO will not show any lower level than INFO:
        To view verbose level log during development, run this command from adb shell.
        setprop  log.tag.MyApp  VERBOSE
        End users will not see the log entries since the default log level is INFO.
         */
        info { myProp2 }
        dd("msggg from ddd")
    }

    var myProp by Delegates.observable("") { _, _, new ->
        toast(new)
    }

    var myProp2 by Delegates.vetoable(5) { _, _, new ->
        new >= 0
    }

}