package uz.mahmudxon.fairy.list.viewholder

import uz.mahmudxon.fairy.databinding.ListItemLayoutBinding
import uz.mahmudxon.fairy.model.Fairytale

class ListViewHolder(private val binding: ListItemLayoutBinding) : BaseViewHolder(binding.root) {

    override fun bind(data: Fairytale) {
        binding.title = data.title
        binding.img = "file:///android_asset/img/${data.img}"
        binding.root.setOnClickListener { callBack?.onItemClick(data) }
    }

}