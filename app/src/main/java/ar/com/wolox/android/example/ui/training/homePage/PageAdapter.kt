package ar.com.wolox.android.example.ui.training.homePage

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import java.lang.Exception

class PageAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            NEWS_FRAGMENT -> { NewsFragment() }
            PROFILE_FRAGMENT -> { ProfileFragment() }
            else -> {
                throw Exception("The Fragment doesn't exist")
            }
        }
    }

    override fun getCount(): Int = 2

    override fun getPageTitle(position: Int): CharSequence {
        return when (position) {
            NEWS_FRAGMENT -> "News"
            PROFILE_FRAGMENT -> "Profile"
            else -> {
                throw Exception("The Tab doesn't exist")
            }
        }
    }

    companion object {
        const val NEWS_FRAGMENT = 0
        const val PROFILE_FRAGMENT = 1
    }
}