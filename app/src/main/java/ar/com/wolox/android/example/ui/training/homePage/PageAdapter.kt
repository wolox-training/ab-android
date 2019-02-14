package ar.com.wolox.android.example.ui.training.homePage

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import ar.com.wolox.android.example.ui.training.homePage.news.NewsFragment
import javax.inject.Inject

class PageAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {

    @Inject lateinit var mNewsFragment: NewsFragment

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                mNewsFragment
            }
            else -> {
                ProfileFragment()
            }
        }
    }

    override fun getCount(): Int = 2

    override fun getPageTitle(position: Int): CharSequence {
        return when (position) {
            0 -> "News"
            else -> {
                "Profile"
            }
        }
    }
}