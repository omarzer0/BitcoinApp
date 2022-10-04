package az.zero.bitcoin.data.repository

import az.zero.bitcoin.data.local.BitcoinDatabase
import az.zero.bitcoin.data.local.model.CachedBitcoin
import az.zero.bitcoin.data.network.ApiService
import az.zero.bitcoin.data.network.model.ApiBitcoin
import az.zero.bitcoin.domian.repository.BitcoinRepository
import kotlinx.coroutines.flow.Flow

class BitcoinRepositoryImpl(
    private val api: ApiService,
    private val database: BitcoinDatabase,
) : BitcoinRepository {

    private val dao = database.getBitcoinDao()

    override suspend fun getBitCoin(): ApiBitcoin = api.getBitCoin()

    override fun getAllBitcoins(): Flow<List<CachedBitcoin>> = dao.getAllBitcoins()

    override suspend fun insert(cachedBitcoin: CachedBitcoin): Long = dao.insert(cachedBitcoin)

    override suspend fun getLastInsertedCached(): List<CachedBitcoin> = dao.getLastInsertedCached()

    override suspend fun delete(cachedBitcoin: CachedBitcoin) = cachedBitcoin.id?.let {
        dao.delete(it)
    } ?: Unit

    override suspend fun saveIfNotExceededFifty(newCachedBitcoin: CachedBitcoin) {
        val cachedBitcoins = dao.getLastInsertedCached()
        if (cachedBitcoins.size > 49) {
            val lastItem = cachedBitcoins.last()
            lastItem.id?.let {
                dao.delete(it)
                dao.insert(newCachedBitcoin)
            }
        } else {
            dao.insert(newCachedBitcoin)
        }
    }
}