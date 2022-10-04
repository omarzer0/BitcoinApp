package az.zero.bitcoin.domian.model

data class UiBitcoin(
    val time: Time,
    val disclaimer: String,
    val chartName: String,
    val bpi: Bpi,
)