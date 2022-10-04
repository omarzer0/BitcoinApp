package az.zero.bitcoin.domian.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Bpi(
    val USD: USD,
) : Parcelable