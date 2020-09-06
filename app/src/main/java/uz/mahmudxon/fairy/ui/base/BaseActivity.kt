package uz.mahmudxon.fairy.ui.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity(@LayoutRes val layoutID: Int) : AppCompatActivity() {

    open val canChangeTheme: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(layoutID)
        onAfterCreate()
    }

    abstract fun onAfterCreate()

}