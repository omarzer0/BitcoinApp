package az.zero.bitcoin.data.use_case

import az.zero.bitcoin.core.ResponseState
import az.zero.bitcoin.core.networkBoundResponseState
import az.zero.bitcoin.data.mappers.toCachedBitcoin
import az.zero.bitcoin.data.mappers.toUIBitcoin
import az.zero.bitcoin.domian.model.UiBitcoin
import az.zero.bitcoin.domian.repository.BitcoinRepository
import az.zero.bitcoin.domian.use_case.GetAllBitCoinsUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetAllBitCoinsUseCaseImpl(
    private val bitcoinRepository: BitcoinRepository,
) : GetAllBitCoinsUseCase {

    override fun execute(): Flow<ResponseState<List<UiBitcoin>>> = networkBoundResponseState(
        query = {
            bitcoinRepository.getAllBitcoins().map { list ->
                list.map { it.toUIBitcoin() }
            }
        },
        fetch = {
            bitcoinRepository.getBitCoin()
        },
        saveFetchResult = {
            bitcoinRepository.saveIfNotExceededFifty(it.toCachedBitcoin())
        }
    )

}