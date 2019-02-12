package ar.com.wolox.android.example.ui.training.homePage

import ar.com.wolox.android.R
import ar.com.wolox.wolmo.core.fragment.WolmoFragment
import ar.com.wolox.wolmo.core.presenter.BasePresenter
import kotlinx.android.synthetic.main.fragment_viewpager.*
import javax.inject.Inject

/**
 * LoginFragment is used for user to Login
 */
class HomePageViewPagerFragment @Inject constructor() : WolmoFragment<BasePresenter<Any>>() {

    private lateinit var fragmentPagerAdapter: PageAdapter

    override fun layout(): Int = ar.com.wolox.android.R.layout.fragment_viewpager

    override fun init() {
        fragmentPagerAdapter = PageAdapter(activity!!.supportFragmentManager)
        pager.adapter = fragmentPagerAdapter
        tabs.setupWithViewPager(pager)
        tabs.getTabAt(0)?.setIcon(R.drawable.news_selector)
        tabs.getTabAt(1)?.setIcon(R.drawable.profile_selector)
    }
}
