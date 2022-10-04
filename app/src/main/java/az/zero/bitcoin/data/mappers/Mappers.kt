package az.zero.bitcoin.data.mappers

import az.zero.bitcoin.data.local.model.CachedBitcoin
import az.zero.bitcoin.data.network.model.ApiBitcoin
import az.zero.bitcoin.domian.model.UiBitcoin

fun ApiBitcoin.toCachedBitcoin() = CachedBitcoin(
    time, disclaimer, chartName, bpi
)

fun CachedBitcoin.toUIBitcoin() = UiBitcoin(
    time, disclaimer, chartName, bpi
)