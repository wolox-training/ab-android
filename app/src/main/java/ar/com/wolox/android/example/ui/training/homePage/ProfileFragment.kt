package ar.com.wolox.android.example.ui.training.homePage

import ar.com.wolox.android.R
import ar.com.wolox.wolmo.core.fragment.WolmoFragment
import ar.com.wolox.wolmo.core.presenter.BasePresenter
import javax.inject.Inject

/**
 * LoginFragment is used for user to Login
 */
class ProfileFragment @Inject constructor() : WolmoFragment<BasePresenter<Any>>() {

    override fun init() {}

    override fun layout(): Int = ar.com.wolox.android.R.layout.fragment_profile_page
}