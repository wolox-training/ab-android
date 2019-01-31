package ar.com.wolox.android.example.ui.training.login;

import ar.com.wolox.android.R;
import ar.com.wolox.wolmo.core.fragment.WolmoFragment;

/**
 * LoginFragment is used for user to Login
 */
public class LoginFragment extends WolmoFragment {

    @Override
    public int layout() {
        return R.layout.fragment_login;
    }

    @Override
    public void init() {

    }

    public static LoginFragment newInstance() {

        LoginFragment fragment = new LoginFragment();
        return fragment;
    }
}
