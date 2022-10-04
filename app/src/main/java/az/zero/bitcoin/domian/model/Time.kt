package az.zero.bitcoin.domian.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Time(
    val updated: String,
    val updatedISO: String,
    val updateduk: String,
) : Parcelable