package az.zero.bitcoin.presentation

import az.zero.bitcoin.domian.model.UiBitcoin

data class MainUiState(
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val error: String = "",
    val bitcoins: List<UiBitcoin> = emptyList(),
)
