package uz.mahmudxon.fairy.ui.main

import android.view.MenuItem
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import uz.mahmudxon.fairy.R
import uz.mahmudxon.fairy.databinding.FragmentMainBinding
import uz.mahmudxon.fairy.list.Adapter
import uz.mahmudxon.fairy.list.IAdapterCallBack
import uz.mahmudxon.fairy.model.Fairytale
import uz.mahmudxon.fairy.ui.MainActivity
import uz.mahmudxon.fairy.ui.base.BaseFragment
import uz.mahmudxon.fairy.util.Prefs

class MainFragment : BaseFragment(R.layout.fragment_main), IAdapterCallBack, View.OnClickListener,
    Toolbar.OnMenuItemClickListener {

    private val viewModel: MainViewModel by viewModel()
    lateinit var binding: FragmentMainBinding
    private val adapter: Adapter by inject()
    private val navController: NavController by lazy { findNavController() }
    private val prefs: Prefs by inject()
    private val useVolumeButtons: Boolean
        get() = prefs.get(prefs.useVolumeKeys, false)

    override fun onCreate(view: View) {
        binding = dataBinding as FragmentMainBinding
        binding.list.layoutManager = LinearLayoutManager(context)
        binding.list.adapter = adapter
        adapter.itemClick = this
        binding.onClick = this
        viewModel.data.observe(this, { adapter.setData(it) })
        binding.toolbar.setOnMenuItemClickListener(this)
    }

    override fun onItemClick(data: Fairytale) {
        navController.navigate(R.id.action_mainFragment_to_storyFragment, bundleOf("id" to data.id))
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.search -> openSearchFragment()
            R.id.settings -> navController.navigate(R.id.action_mainFragment_to_settingsFragment)
            R.id.menu -> (activity as MainActivity?)?.openDrawer()
        }
    }

    private fun openSearchFragment() {
        navController.navigate(R.id.action_mainFragment_to_searchFragment)
    }

    override fun onMenuItemClick(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            R.id.item_search -> {
                openSearchFragment()
                true
            }
            else -> false
        }
    }

    override fun onKeyUpPress() {
        if (useVolumeButtons) {
            binding.list.smoothScrollBy(-400, -400)
            return
        }
        super.onKeyUpPress()
    }

    override fun onKeyDownPress() {
        if (useVolumeButtons) {
            binding.list.smoothScrollBy(400, 400)
            return
        }
        super.onKeyDownPress()
    }

}