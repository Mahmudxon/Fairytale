package uz.mahmudxon.fairy.ui.story

import android.view.View
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import uz.mahmudxon.fairy.R
import uz.mahmudxon.fairy.databinding.FragmentStoryBinding
import uz.mahmudxon.fairy.model.Fairytale
import uz.mahmudxon.fairy.ui.base.BaseFragment
import uz.mahmudxon.fairy.util.FontSizeManager
import uz.mahmudxon.fairy.util.bindImage
import uz.mahmudxon.fairy.util.visibility

class StoryFragment : BaseFragment(R.layout.fragment_story), View.OnClickListener {

    private val binding: FragmentStoryBinding by lazy { (dataBinding as FragmentStoryBinding) }
    private var storyID = 0
    private val vm: StoryViewModel by viewModel()
    private val fontSizeManager: FontSizeManager by inject()

    override fun onCreate(view: View) {
        binding.onClick = this
        binding.largeFontSize = fontSizeManager.largeTextSize
        binding.fontSize = fontSizeManager.currentSize
        arguments?.let {
            storyID = it.getInt("id")
        }
        vm.getStories(storyID)
        vm.getStories().observe(this, { setStories(it) })
    }

    private fun setStories(data: List<Fairytale>) {
        setPrev(data.first())
        setNext(data.last())
        data.find { f -> f.id == storyID }?.let {
            setCurrent(it)
        }
    }

    private fun setPrev(data: Fairytale) {
        if (data.id == storyID) {
            // No prev data
            binding.prev.visibility = View.INVISIBLE
            return
        }
        binding.prev.visibility = View.VISIBLE
        binding.prevText = data.title
    }

    private fun setNext(data: Fairytale) {
        if (data.id == storyID) {
            // No next data
            binding.next.visibility = View.INVISIBLE
            return
        }
        binding.next.visibility = View.VISIBLE
        binding.nextText = data.title
    }

    private fun setCurrent(data: Fairytale) {
        binding.titleText = data.title
        binding.img.visibility(data.img != null)
        binding.img.bindImage("file:///android_asset/img/${data.img}")
        binding.storyText = data.story
        binding.scrollView.fullScroll(0)
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.back -> finish()
            R.id.next -> vm.getStories(++storyID)
            R.id.prev -> vm.getStories(--storyID)
        }
    }
}