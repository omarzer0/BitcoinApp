package az.zero.bitcoin.data.network

import az.zero.bitcoin.data.network.model.ApiBitcoin
import retrofit2.http.GET

interface ApiService {

    @GET("bpi/currentprice.json")
    suspend fun getBitCoin(): ApiBitcoin

}