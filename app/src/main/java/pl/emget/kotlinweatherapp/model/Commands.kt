package pl.emget.kotlinweatherapp.model

interface  Command<out T> {
    fun execute(): T
}