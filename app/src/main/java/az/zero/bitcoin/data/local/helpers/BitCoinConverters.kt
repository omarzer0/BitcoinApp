package az.zero.bitcoin.data.local.helpers

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import az.zero.bitcoin.domian.model.Bpi
import az.zero.bitcoin.domian.model.Time
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

@ProvidedTypeConverter
class BitCoinConverters {

    @TypeConverter
    fun listOfStringToString(list: List<String>?): String? = list?.let { Gson().toJson(it) }

    @TypeConverter
    fun stringToListOfStrings(string: String?): List<String>? {
        val listType = object : TypeToken<List<String?>?>() {}.type
        return string?.let { Gson().fromJson(it, listType) }
    }

    @TypeConverter
    fun fromTime(time: Time): String {
        return Gson().toJson(time)
    }

    @TypeConverter
    fun toTime(string: String): Time {
        return Gson().fromJson(string, Time::class.java)
    }

    @TypeConverter
    fun fromBpi(bpi: Bpi): String {
        return Gson().toJson(bpi)
    }

    @TypeConverter
    fun toBpi(string: String): Bpi {
        return Gson().fromJson(string, Bpi::class.java)
    }

}