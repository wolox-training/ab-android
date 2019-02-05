package ar.com.wolox.android.example.ui.training.homePage;

import ar.com.wolox.android.R;
import ar.com.wolox.wolmo.core.fragment.WolmoFragment;

/**
 * LoginFragment is used for user to Login
 */
public class HomePageFragment extends WolmoFragment {

    @Override
    public int layout() {
        return R.layout.fragment_home_page;
    }

    @Override
    public void init() {
    }

    public static HomePageFragment newInstance() {
        HomePageFragment fragment = new HomePageFragment();
        return fragment;
    }
}
