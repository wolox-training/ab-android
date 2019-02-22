package ar.com.wolox.android.example.ui.training.homePage

import ar.com.wolox.android.R
import ar.com.wolox.wolmo.core.activity.WolmoActivity
import dagger.Lazy
import javax.inject.Inject

/**
 *
 */
class HomePageViewPagerActivity : WolmoActivity() {

    @Inject internal lateinit var lazyViewpagerFragment: Lazy<HomePageViewPagerFragment>

    override fun layout(): Int = R.layout.activity_base

    override fun init() {
        replaceFragment(R.id.vActivityBaseContent, lazyViewpagerFragment.get())
    }
}
