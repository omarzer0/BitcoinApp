package az.zero.bitcoin.domian.repository

import az.zero.bitcoin.data.local.model.CachedBitcoin
import az.zero.bitcoin.data.network.model.ApiBitcoin
import kotlinx.coroutines.flow.Flow

interface BitcoinRepository {

    suspend fun getBitCoin(): ApiBitcoin

    fun getAllBitcoins(): Flow<List<CachedBitcoin>>

    suspend fun insert(cachedBitcoin: CachedBitcoin): Long

    suspend fun getLastInsertedCached(): List<CachedBitcoin>

    suspend fun delete(cachedBitcoin: CachedBitcoin)

    suspend fun saveIfNotExceededFifty(newCachedBitcoin: CachedBitcoin)

}