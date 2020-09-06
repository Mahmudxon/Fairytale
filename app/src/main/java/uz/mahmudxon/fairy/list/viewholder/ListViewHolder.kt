package uz.mahmudxon.fairy.list.viewholder

import org.koin.core.inject
import uz.mahmudxon.fairy.databinding.ListItemLayoutBinding
import uz.mahmudxon.fairy.model.Fairytale
import uz.mahmudxon.fairy.util.FontSizeManager

class ListViewHolder(private val binding: ListItemLayoutBinding) : BaseViewHolder(binding.root) {

    private val fontSizeManager: FontSizeManager by inject()

    override fun bind(data: Fairytale) {
        binding.title = data.title
        binding.img = "file:///android_asset/img/${data.img}"
        binding.root.setOnClickListener { callBack?.onItemClick(data) }
        binding.fontSize = fontSizeManager.largeTextSize
    }

}