package ar.com.wolox.android.example.di

import ar.com.wolox.android.example.ui.training.homePage.HomePageActivity
import ar.com.wolox.android.example.ui.training.homePage.HomePageFragment
import ar.com.wolox.android.example.ui.training.signUp.SignUpActivity
import ar.com.wolox.android.example.ui.training.signUp.SignUpFragment
import ar.com.wolox.android.example.ui.training.login.LoginActivity
import ar.com.wolox.android.example.ui.training.login.LoginFragment
import ar.com.wolox.android.example.ui.training.root.RootActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class AppModule {

    @ContributesAndroidInjector
    internal abstract fun rootActivity(): RootActivity

    @ContributesAndroidInjector
    internal abstract fun loginActivity(): LoginActivity

    @ContributesAndroidInjector
    internal abstract fun loginFragment(): LoginFragment

    @ContributesAndroidInjector
    internal abstract fun homePageActivity(): HomePageActivity

    @ContributesAndroidInjector
    internal abstract fun homePageFragment(): HomePageFragment

    @ContributesAndroidInjector
    internal abstract fun signUpActivity(): SignUpActivity

    @ContributesAndroidInjector
    internal abstract fun signUpFragment(): SignUpFragment
}
