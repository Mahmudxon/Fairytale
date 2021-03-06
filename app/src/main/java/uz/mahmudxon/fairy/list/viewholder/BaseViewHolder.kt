package uz.mahmudxon.fairy.list.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import org.koin.core.KoinComponent
import uz.mahmudxon.fairy.list.IAdapterCallBack
import uz.mahmudxon.fairy.model.Fairytale

abstract class BaseViewHolder(view: View) : RecyclerView.ViewHolder(view), KoinComponent {
    var callBack: IAdapterCallBack? = null
    abstract fun bind(data: Fairytale)
}