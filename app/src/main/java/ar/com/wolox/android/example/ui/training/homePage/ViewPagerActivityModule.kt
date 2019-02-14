package ar.com.wolox.android.example.ui.training.homePage

import android.app.Activity
import ar.com.wolox.android.example.ui.training.homePage.news.NewsFragment

import dagger.Binds
import dagger.Module
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module(subcomponents = [(ViewPagerActivitySubcomponent::class)])
abstract class ViewPagerActivityModule {

    @Binds
    @IntoMap
    @ActivityKey(HomePageViewPagerActivity::class)
    internal abstract fun bindViewPagerActivityFactory(
        builder: ViewPagerActivitySubcomponent.Builder
    ): AndroidInjector.Factory<out Activity>

    @ContributesAndroidInjector
    internal abstract fun viewpagerFragment(): HomePageViewPagerFragment

    @ContributesAndroidInjector
    internal abstract fun randomFragment(): NewsFragment

    @ContributesAndroidInjector
    internal abstract fun profileFragment(): ProfileFragment
}
