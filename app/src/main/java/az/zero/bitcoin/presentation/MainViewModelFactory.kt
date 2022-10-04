package az.zero.bitcoin.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import az.zero.bitcoin.domian.use_case.GetAllBitCoinsUseCase

class MainViewModelFactory(
    private val getAllBitCoinsUseCase: GetAllBitCoinsUseCase,
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(getAllBitCoinsUseCase) as T
    }
}