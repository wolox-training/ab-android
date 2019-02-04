package ar.com.wolox.android.example.ui.training.login;

import javax.inject.Inject;

import ar.com.wolox.wolmo.core.presenter.BasePresenter;

/**
 * LoginPresenter is used for user to Login
 */

public class LoginPresenter extends BasePresenter<ILoginView> {

    @Inject
    public LoginPresenter() {
    }

    /**
     * @param email    Email to validate.
     * @param password Password to validate.
     */
    public void validateFields(String email, String password) {
        if (email.isEmpty() || password.isEmpty()) {
            validateCompleteFields(email, password);
        } else if (!validateEmail(email)) {
            getView().incorrectEmail();
        } else {
            getView().loginSuccesful();
        }
    }

    /**
     * @param email Email to validate.
     * @param password Password to validate
     */
    public void validateCompleteFields(String email, String password) {
        if (email.isEmpty() && password.isEmpty()) {
            getView().incompleteEmail();
            getView().incompletePassword();
        } else {
            if (email.isEmpty() && !password.isEmpty()) {
                getView().incompleteEmail();
            } else {
                if (!email.isEmpty() && password.isEmpty()) {
                    getView().incompletePassword();
                }
            }
        }
    }

    public boolean validateEmail(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\" +
                ".[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }
}
