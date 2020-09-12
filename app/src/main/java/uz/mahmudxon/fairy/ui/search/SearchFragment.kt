package uz.mahmudxon.fairy.ui.search

import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import uz.mahmudxon.fairy.R
import uz.mahmudxon.fairy.databinding.FragmentSearchBinding
import uz.mahmudxon.fairy.list.Adapter
import uz.mahmudxon.fairy.list.IAdapterCallBack
import uz.mahmudxon.fairy.model.Fairytale
import uz.mahmudxon.fairy.ui.base.BaseFragment

class SearchFragment : BaseFragment(R.layout.fragment_search), TextWatcher, IAdapterCallBack {

    private val binding: FragmentSearchBinding by lazy { (dataBinding as FragmentSearchBinding) }
    private val adapter: Adapter by inject()
    private val vm: SearchViewModel by viewModel()
    private val navController: NavController by lazy { findNavController() }


    override fun onCreate(view: View) {
        binding.back.setOnClickListener { finish() }
        showKeyboard(binding.search)
        binding.list.layoutManager = LinearLayoutManager(context)
        binding.list.adapter = adapter
        binding.search.addTextChangedListener(this)
        adapter.itemClick = this
        vm.getStories().observe(this, { adapter.setData(it) })
        vm.getStories("bla bla bla") // to clear data from view model scope
    }

    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

    }

    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

    }

    override fun afterTextChanged(p0: Editable?) {
        if (!p0.isNullOrEmpty())
            vm.getStories(p0.toString())
        else vm.getStories("bla bla bla")
    }

    override fun onItemClick(data: Fairytale) {
        navController.navigate(
            R.id.action_searchFragment_to_storyFragment,
            bundleOf("id" to data.id)
        )
    }

    override fun onPause() {
        hideKeyBoard()
        super.onPause()
    }
}