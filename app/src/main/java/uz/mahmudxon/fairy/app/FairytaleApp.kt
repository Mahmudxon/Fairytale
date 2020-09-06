package uz.mahmudxon.fairy.app

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.fragment.koin.fragmentFactory
import org.koin.core.context.startKoin
import uz.mahmudxon.fairy.module.*

class FairytaleApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            fragmentFactory()
            androidContext(applicationContext)
            modules(appModule, dbModule, mainModule, storyModule, searchModule)
        }
    }
}