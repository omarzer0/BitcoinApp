package az.zero.bitcoin.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import az.zero.bitcoin.domian.use_case.GetAllBitCoinsUseCase
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class MainViewModel(
    private val getAllBitCoinsUseCase: GetAllBitCoinsUseCase,
) : ViewModel() {

    private val channel = Channel<Refresher>()
    private val trigger = channel.consumeAsFlow()

    val mainUiSate: LiveData<MainUiState> = trigger.flatMapLatest {
        getAllBitCoinsUseCase.execute().map {
            it.toUiMainState()
        }
    }.stateIn(viewModelScope, SharingStarted.Lazily, MainUiState()).asLiveData()

    private suspend fun getNewBitcoin() = flow {
        while (true) {
            emit(Unit)
            delay(2000)
        }
    }.onEach {
        Log.d("getNewBitcoin", "getNewBitcoin")
        channel.send(Refresher.FORCED)
    }


    init {
        viewModelScope.launch {
            getNewBitcoin().collect()
        }
    }

    enum class Refresher {
        INITIAL,
        FORCED
    }
}