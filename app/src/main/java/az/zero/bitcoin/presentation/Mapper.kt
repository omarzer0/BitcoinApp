package az.zero.bitcoin.presentation

import az.zero.bitcoin.core.ResponseState
import az.zero.bitcoin.domian.model.UiBitcoin

fun ResponseState<List<UiBitcoin>>.toUiMainState(): MainUiState {
    return when (val response = this) {
        is ResponseState.Error -> MainUiState(
            isLoading = false,
            isError = true,
            error = response.message ?: "Unknown Error",
            bitcoins = response.data ?: emptyList()
        )
        is ResponseState.Loading -> MainUiState(
            isLoading = true,
            isError = false,
            error = response.message ?: "Unknown Error",
            bitcoins = response.data ?: emptyList()
        )
        is ResponseState.Success -> MainUiState(
            isLoading = false,
            isError = false,
            error = response.message ?: "Unknown Error",
            bitcoins = response.data ?: emptyList()
        )
    }

}