package uz.mahmudxon.fairy.ui.base

import android.content.Context
import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

abstract class BaseFragment(@LayoutRes private val layout: Int) : Fragment(), View.OnKeyListener {

    private var isUseBackPress = true
    private var isUseKeyUpPress = true
    private var isUseKeyDownPress = true

    protected lateinit var dataBinding: ViewDataBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBinding = DataBindingUtil.inflate(inflater, layout, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.isFocusableInTouchMode = true
        view.requestFocus()
        view.setOnKeyListener(this)
        onCreate(view)
    }

    abstract fun onCreate(view: View)


    open fun onBackPressed() {
        isUseBackPress = false
    }

    fun finish() {
        findNavController().popBackStack()
    }


    fun hideKeyBoard() {
        val view = activity?.currentFocus ?: View(activity)
        val imm = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

    fun showKeyboard(editText: EditText) {
        editText.requestFocus()
        val imm = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(editText, 0)
    }

    override fun onKey(p0: View?, keyCode: Int, e: KeyEvent?): Boolean {

        // back press
        if (keyCode == KeyEvent.KEYCODE_BACK && e?.action == KeyEvent.ACTION_DOWN) {
            isUseBackPress = true
            onBackPressed()
            return isUseBackPress
        }

        if (keyCode == KeyEvent.KEYCODE_VOLUME_UP && e?.action == KeyEvent.ACTION_DOWN) {
            isUseKeyUpPress = true
            onKeyUpPress()
            return isUseKeyUpPress
        }

        if (keyCode == KeyEvent.KEYCODE_VOLUME_DOWN && e?.action == KeyEvent.ACTION_DOWN) {
            isUseKeyDownPress = true
            onKeyDownPress()
            return isUseKeyDownPress
        }

        return false
    }

    open fun onKeyUpPress() {
        isUseKeyUpPress = false
    }

    open fun onKeyDownPress() {
        isUseKeyDownPress = false
    }
}