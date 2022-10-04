package az.zero.bitcoin.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import az.zero.bitcoin.databinding.ItemBitcoinBinding
import az.zero.bitcoin.domian.model.UiBitcoin

class BitcoinAdapter :
    ListAdapter<UiBitcoin, BitcoinAdapter.BitcoinViewHolder>(BitcoinDiffUtils()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BitcoinViewHolder {
        val binding = ItemBitcoinBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BitcoinViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BitcoinViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    inner class BitcoinViewHolder(val binding: ItemBitcoinBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(bitcoin: UiBitcoin) {
            binding.apply {
                tvPrice.text = bitcoin.bpi.USD.rate
                tvTime.text = bitcoin.time.updated
            }
        }
    }

    class BitcoinDiffUtils : DiffUtil.ItemCallback<UiBitcoin>() {
        override fun areItemsTheSame(oldItem: UiBitcoin, newItem: UiBitcoin) = oldItem == newItem

        override fun areContentsTheSame(oldItem: UiBitcoin, newItem: UiBitcoin) = oldItem == newItem

    }


}