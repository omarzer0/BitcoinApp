package az.zero.bitcoin.domian.use_case

import az.zero.bitcoin.core.ResponseState
import az.zero.bitcoin.domian.model.UiBitcoin
import kotlinx.coroutines.flow.Flow

interface GetAllBitCoinsUseCase {
    fun execute(): Flow<ResponseState<List<UiBitcoin>>>
}