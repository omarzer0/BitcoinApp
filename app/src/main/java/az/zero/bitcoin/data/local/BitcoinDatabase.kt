package az.zero.bitcoin.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import az.zero.bitcoin.data.local.helpers.BitCoinConverters
import az.zero.bitcoin.data.local.model.CachedBitcoin

@Database(
    version = 1,
    entities = [CachedBitcoin::class]
)
@TypeConverters(BitCoinConverters::class)
abstract class BitcoinDatabase : RoomDatabase() {

    abstract fun getBitcoinDao(): BitcoinDao


    companion object {
        const val DATABASE_NAME = "bitcoin_db"
    }
}