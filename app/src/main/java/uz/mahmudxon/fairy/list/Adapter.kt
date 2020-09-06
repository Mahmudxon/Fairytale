package uz.mahmudxon.fairy.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import uz.mahmudxon.fairy.R
import uz.mahmudxon.fairy.databinding.ListItemLayoutBinding
import uz.mahmudxon.fairy.list.viewholder.BaseViewHolder
import uz.mahmudxon.fairy.list.viewholder.ListViewHolder
import uz.mahmudxon.fairy.model.Fairytale

class Adapter : RecyclerView.Adapter<BaseViewHolder>() {

    private var elements: ArrayList<Fairytale> = ArrayList()
    var itemClick : IAdapterCallBack ?= null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ListItemLayoutBinding =
            DataBindingUtil.inflate(inflater, R.layout.list_item_layout, parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.bind(elements[position])
        holder.callBack = this.itemClick
    }

    override fun getItemCount(): Int {
        return elements.size
    }

    fun setData(data : List<Fairytale>)
    {
        elements.clear()
        elements.addAll(data)
        notifyDataSetChanged()
    }
}