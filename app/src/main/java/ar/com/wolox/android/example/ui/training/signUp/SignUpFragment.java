package ar.com.wolox.android.example.ui.training.signUp;

import ar.com.wolox.android.R;
import ar.com.wolox.wolmo.core.fragment.WolmoFragment;

/**
 * LoginFragment is used for user to Login
 */
public class SignUpFragment extends WolmoFragment {

    @Override
    public int layout() {
        return R.layout.fragment_sign_up;
    }

    @Override
    public void init() {
    }

    public static SignUpFragment newInstance() {
        SignUpFragment fragment = new SignUpFragment();
        return fragment;
    }
}
