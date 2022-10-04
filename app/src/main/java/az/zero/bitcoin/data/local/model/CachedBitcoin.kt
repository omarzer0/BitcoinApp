package az.zero.bitcoin.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import az.zero.bitcoin.domian.model.Bpi
import az.zero.bitcoin.domian.model.Time

@Entity
data class CachedBitcoin(
    val time: Time,
    val disclaimer: String,
    val chartName: String,
    val bpi: Bpi,
    val savedTime: Long = System.currentTimeMillis(),
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,
)