package ar.com.wolox.android.example.ui.training.homePage

import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent
interface ViewPagerActivitySubcomponent : AndroidInjector<HomePageViewPagerActivity> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<HomePageViewPagerActivity>()
}
