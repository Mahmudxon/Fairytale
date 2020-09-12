package uz.mahmudxon.fairy.ui

import android.view.MenuItem
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.findNavController
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.fragment.android.setupKoinFragmentFactory
import uz.mahmudxon.fairy.R
import uz.mahmudxon.fairy.ui.base.BaseActivity

class MainActivity : BaseActivity(R.layout.activity_main),
    NavigationView.OnNavigationItemSelectedListener {

    private val navController: NavController by lazy { findNavController(R.id.container) }
    private val navOptions: NavOptions by lazy { getDefaultNavOptions() }

    override fun onAfterCreate() {
        setupKoinFragmentFactory()
        drawer?.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
        nav?.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        if (drawer?.isDrawerOpen(GravityCompat.START) == true) {
            drawer?.closeDrawer(GravityCompat.START)
            return
        }
        super.onBackPressed()
    }

    fun openDrawer() {
        drawer?.openDrawer(GravityCompat.START)
    }

    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        drawer?.closeDrawer(GravityCompat.START)
        when (p0.itemId) {
            R.id.settings -> {
                navController.navigate(R.id.settingsFragment, null, navOptions)
            }
            R.id.info -> navController.navigate(R.id.aboutFragment, null, navOptions)
        }
        return true
    }

    private fun getDefaultNavOptions() = NavOptions.Builder()
        .setEnterAnim(android.R.anim.fade_in)
        .setExitAnim(android.R.anim.fade_out)
        .setPopEnterAnim(android.R.anim.slide_in_left)
        .setPopExitAnim(android.R.anim.slide_out_right)
        .build()
}