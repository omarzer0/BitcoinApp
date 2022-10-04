package az.zero.bitcoin.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import az.zero.bitcoin.data.local.di.DatabaseModule
import az.zero.bitcoin.data.network.di.NetworkModule
import az.zero.bitcoin.data.repository.BitcoinRepositoryImpl
import az.zero.bitcoin.data.use_case.GetAllBitCoinsUseCaseImpl
import az.zero.bitcoin.databinding.ActivityMainBinding
import az.zero.bitcoin.presentation.adapter.BitcoinAdapter

class MainActivity : AppCompatActivity() {
    private val bitcoinAdapter = BitcoinAdapter()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bitcoinRepository = BitcoinRepositoryImpl(
            NetworkModule.newInstance(),
            DatabaseModule.bitcoinDatabase(applicationContext),
        )

        val useCase = GetAllBitCoinsUseCaseImpl(bitcoinRepository)

        val viewModel =
            ViewModelProvider(this, MainViewModelFactory(useCase))[MainViewModel::class.java]

        binding.rv.adapter = bitcoinAdapter
        viewModel.mainUiSate.observe(this) {
            bitcoinAdapter.submitList(it.bitcoins)
        }

    }

    companion object {
        const val TAG = "MainActivity"
    }
}