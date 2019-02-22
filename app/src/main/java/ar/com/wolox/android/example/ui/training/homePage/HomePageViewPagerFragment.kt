package ar.com.wolox.android.example.ui.training.homePage

import ar.com.wolox.android.R
import ar.com.wolox.wolmo.core.fragment.WolmoFragment
import ar.com.wolox.wolmo.core.presenter.BasePresenter
import kotlinx.android.synthetic.main.fragment_viewpager.*
import javax.inject.Inject
import ar.com.wolox.wolmo.core.adapter.viewpager.SimpleFragmentPagerAdapter
import android.support.v4.util.Pair
import ar.com.wolox.android.example.ui.training.homePage.news.NewsFragment

/**
 * LoginFragment is used for user to Login
 */
class HomePageViewPagerFragment @Inject constructor() : WolmoFragment<BasePresenter<Any>>() {

    @Inject lateinit var newsFragment: NewsFragment
    @Inject lateinit var profileFragment: ProfileFragment
    private lateinit var fragmentPagerAdapter: SimpleFragmentPagerAdapter

    override fun layout(): Int = ar.com.wolox.android.R.layout.fragment_viewpager

    override fun init() {

        fragmentPagerAdapter = SimpleFragmentPagerAdapter(childFragmentManager)
        fragmentPagerAdapter.addFragments(
                Pair(newsFragment, getString(R.string.news)),
                Pair(profileFragment, getString(R.string.homepage_profile))
        )

        vViewPagerPager.adapter = fragmentPagerAdapter
        tabs.setupWithViewPager(vViewPagerPager)
        tabs.getTabAt(Companion.NEWS_FRAGMENT)?.setIcon(R.drawable.news_selector)
        tabs.getTabAt(Companion.PROFILE_FRAGMENT)?.setIcon(R.drawable.profile_selector)
    }

    companion object {
        const val NEWS_FRAGMENT = 0
        const val PROFILE_FRAGMENT = 1
    }
}
