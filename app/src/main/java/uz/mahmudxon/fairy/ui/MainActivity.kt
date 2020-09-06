package uz.mahmudxon.fairy.ui

import org.koin.androidx.fragment.android.setupKoinFragmentFactory
import uz.mahmudxon.fairy.R
import uz.mahmudxon.fairy.ui.base.BaseActivity

class MainActivity : BaseActivity(R.layout.activity_main) {
    override fun onAfterCreate() {
        setupKoinFragmentFactory()
    }
}