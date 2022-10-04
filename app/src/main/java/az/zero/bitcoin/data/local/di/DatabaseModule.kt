package az.zero.bitcoin.data.local.di

import android.content.Context
import androidx.room.Room
import az.zero.bitcoin.data.local.BitcoinDatabase
import az.zero.bitcoin.data.local.BitcoinDatabase.Companion.DATABASE_NAME
import az.zero.bitcoin.data.local.helpers.BitCoinConverters

class DatabaseModule private constructor() {

    companion object {

        @Volatile
        private var INSTANCE: BitcoinDatabase? = null
        private val lock = Any()

        @JvmStatic
        fun bitcoinDatabase(context: Context): BitcoinDatabase = INSTANCE ?: synchronized(lock) {
            INSTANCE ?: Room.databaseBuilder(context, BitcoinDatabase::class.java, DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .addTypeConverter(BitCoinConverters())
                .build()
        }
    }
}