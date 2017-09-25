package pl.emget.kotlinweatherapp.database

object CityForecastTable {
    val NAME = "CityForecast"
    val ID = "_id"
    val CITY = "city"
    val COUNTRY = "country"
}

object DayForecastTable {
    val NAME = "DayForecast"
    val ID = "_id"
    val DATE = "date"
    val DESCRIPTION = "description"
    val HIGH = "high"
    val LOW = "low"
    val ICON_URL = "iconUrl"
    val CITY_ID = "cityId"
}

class DayForecast (val map: MutableMap<String, Any?>){
    var _id : Long by map
    var date: Long by map
    var description : String by map
    var high : Int by map
    var low : Int by map
    var iconUrl : String by map
    var cityId : Long by map

    constructor(date: Long, description: String, high: Int, low: Int, iconUrl:String, cityId:Long) : this(HashMap()){
        this.date = date
        this.description = description
        this.high = high
        this.low = low
        this.iconUrl = iconUrl
        this.cityId = cityId
    }
}

class CityForecast (val map: MutableMap<String, Any?>, val dailyForecast: List<DayForecast>) {
    var _id : Long by map
    var city : String by map
    var country : String by map

    constructor(id: Long, city: String, country: String, dailyForecast: List<DayForecast>) : this(HashMap(), dailyForecast){
        this._id = id
        this.city = city
        this.country=country
    }
}