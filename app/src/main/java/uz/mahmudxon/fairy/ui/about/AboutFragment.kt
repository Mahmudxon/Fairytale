package uz.mahmudxon.fairy.ui.about

import android.content.Intent
import android.net.Uri
import android.view.View
import uz.mahmudxon.fairy.BuildConfig
import uz.mahmudxon.fairy.R
import uz.mahmudxon.fairy.databinding.FragmentAboutBinding
import uz.mahmudxon.fairy.ui.base.BaseFragment

class AboutFragment : BaseFragment(R.layout.fragment_about), View.OnClickListener {

    private val binding : FragmentAboutBinding by lazy { dataBinding as FragmentAboutBinding }

    override fun onCreate(view: View) {
        binding.onClick = this
    }

    override fun onClick(p0: View?) {
        when(p0?.id)
        {
            R.id.back -> finish()
            R.id.telegram -> openUrlIntent("https://t.me/joinchat/AAAAAE2VrUfRXVPmv1aygw")

            R.id.facebook -> {
                openUrlIntent("https://fb.com/mahmudxon_uz")
            }
            R.id.gmail -> {
                openUrlIntent("mailto:umarxonovmahmudxon@gamil.com")
            }
            R.id.play_store -> {
                openUrlIntent("https://play.google.com/store/apps/details?id=${BuildConfig.APPLICATION_ID}")
            }
        }
    }

    private fun openUrlIntent(url: String) =
        activity?.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
}