package uz.mahmudxon.fairy.ui.settings

import android.view.View
import android.widget.CompoundButton
import android.widget.SeekBar
import org.koin.android.ext.android.inject
import uz.mahmudxon.fairy.R
import uz.mahmudxon.fairy.databinding.FragmentSettingsBinding
import uz.mahmudxon.fairy.ui.base.BaseFragment
import uz.mahmudxon.fairy.util.FontSizeManager
import uz.mahmudxon.fairy.util.Prefs

class SettingsFragment : BaseFragment(R.layout.fragment_settings), View.OnClickListener,
    CompoundButton.OnCheckedChangeListener, SeekBar.OnSeekBarChangeListener {

    private val binding: FragmentSettingsBinding by lazy { dataBinding as FragmentSettingsBinding }
    private val fontSizeManager: FontSizeManager by inject()
    private val prefs: Prefs by inject()

    override fun onCreate(view: View) {
        binding.onClick = this
        binding.checkbox.isChecked = prefs.get(prefs.useVolumeKeys, false)
        binding.checkbox.setOnCheckedChangeListener(this)
        binding.seekBar.max = fontSizeManager.maxSize - fontSizeManager.minSize
        binding.seekBar.progress = fontSizeManager.currentSize - fontSizeManager.minSize
        setTextSize()
        binding.seekBar.setOnSeekBarChangeListener(this)
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.back -> finish()
            R.id.volume_keys -> binding.checkbox.isChecked = !binding.checkbox.isChecked
        }
    }

    override fun onCheckedChanged(p0: CompoundButton?, p1: Boolean) {
        prefs.save(prefs.useVolumeKeys, p1)
    }

    private fun setTextSize() {
        binding.fontSizeWatcher.text = "${fontSizeManager.currentSize}"
        binding.fontSize = fontSizeManager.currentSize
        binding.largeFontSize = fontSizeManager.largeTextSize
    }

    override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
        fontSizeManager.currentSize = p1 + fontSizeManager.minSize
        setTextSize()
    }

    override fun onStartTrackingTouch(p0: SeekBar?) {

    }

    override fun onStopTrackingTouch(p0: SeekBar?) {

    }
}