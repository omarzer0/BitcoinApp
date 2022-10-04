package az.zero.bitcoin.data.network.model

import az.zero.bitcoin.domian.model.Bpi
import az.zero.bitcoin.domian.model.Time
import com.google.gson.annotations.SerializedName

data class ApiBitcoin(
    @SerializedName("time") val time: Time,
    @SerializedName("disclaimer") val disclaimer: String,
    @SerializedName("chartName") val chartName: String,
    @SerializedName("bpi") val bpi: Bpi,
)