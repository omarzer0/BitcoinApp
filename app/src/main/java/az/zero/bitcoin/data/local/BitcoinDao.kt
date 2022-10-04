package az.zero.bitcoin.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import az.zero.bitcoin.data.local.model.CachedBitcoin
import kotlinx.coroutines.flow.Flow

@Dao
interface BitcoinDao {

    @Query("SELECT * FROM CachedBitcoin")
    fun getAllBitcoins(): Flow<List<CachedBitcoin>>

    @Insert
    suspend fun insert(cachedBitcoin: CachedBitcoin): Long

    @Query("SELECT * FROM CachedBitcoin ORDER BY savedTime DESC")
    suspend fun getLastInsertedCached(): List<CachedBitcoin>

    @Query("DELETE FROM CachedBitcoin WHERE id =:cachedBitcoinId")
    suspend fun delete(cachedBitcoinId: Long)

}