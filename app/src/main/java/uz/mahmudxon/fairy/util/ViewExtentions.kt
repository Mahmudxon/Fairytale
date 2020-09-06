package uz.mahmudxon.fairy.util

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import uz.mahmudxon.fairy.R


@BindingAdapter("onClick")
fun View.onClickListener(onClick: View.OnClickListener?) {
    onClick?.let {
        this.setOnClickListener(it)
    }
}

@BindingAdapter("imageUrl")
fun ImageView.bindImage(imageUrl: String?) {
    imageUrl?.let { url ->
        Glide.with(this.context)
            .load(url)
            .placeholder(R.drawable.logo)
            .error(R.drawable.logo)
            .into(this)
    }
}

@BindingAdapter("visibility")
fun View.visibility(isVisible: Boolean?) {
    this.visibility =
        if (isVisible == true)
            View.VISIBLE
        else View.GONE
}

@BindingAdapter("fontSize")
fun TextView.setFontSize(size: Int) {
    if (size > 0)
        this.textSize = size.toFloat()
}