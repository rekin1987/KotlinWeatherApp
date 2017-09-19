package pl.emget.kotlinweatherapp.model

interface Command<out T> {
    fun execute(): T
}

class RequestForecastCommand(val zip: String) : Command<ForecastList> {
    override fun execute() = ForecastDataMapper().mapToAppModel(Request(zip).run())
}