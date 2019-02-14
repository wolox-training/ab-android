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

//    private lateinit var fragmentPagerAdapter: PageAdapter

    @Inject lateinit var mNewsFragment: NewsFragment
    @Inject lateinit var mProfileFragment: ProfileFragment
    private lateinit var mFragmentPagerAdapter: SimpleFragmentPagerAdapter

    override fun layout(): Int = ar.com.wolox.android.R.layout.fragment_viewpager

    override fun init() {
        mFragmentPagerAdapter = SimpleFragmentPagerAdapter(childFragmentManager)
        mFragmentPagerAdapter.addFragments(
                Pair(mNewsFragment, "News"),
                Pair(mProfileFragment, "Profile")
        )

        vViewPagerPager.adapter = mFragmentPagerAdapter
        tabs.setupWithViewPager(vViewPagerPager)
        tabs.getTabAt(0)?.setIcon(R.drawable.news_selector)
        tabs.getTabAt(1)?.setIcon(R.drawable.profile_selector)
    }
}
