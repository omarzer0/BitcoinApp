package az.zero.bitcoin.domian.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class USD(
    val code: String,
    val symbol: String,
    val rate: String,
    val description: String,
    val rateFloat: Double,
) : Parcelable