package ar.com.wolox.android.example.ui.training.homePage

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ar.com.wolox.android.R

/**
 * LoginFragment is used for user to Login
 */
class ProfileFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.profile_fragment_page, container, false)
    }
}