package ar.com.wolox.android.example.ui.training.login;

import javax.inject.Inject;

import ar.com.wolox.wolmo.core.presenter.BasePresenter;

/**
 * LoginPresenter is used for user to Login
 */

public class LoginPresenter extends BasePresenter<ILoginView> {

    private static final int EMAIL_EMPTY = 0;
    private static final int PASSWORD_EMPTY = 1;
    private static final int EMAIL_PASSWORD_EMPTY = 2;

    @Inject
    public LoginPresenter() {
    }

    /**
     * @param email    Email to validate.
     * @param password Password to validate.
     */
    public void validateFields(String email, String password) {
        if ("".equals(email) || "".equals(password)) {
            getView().incompleteFields(validateCompleteFields(email, password));
        } else if (!validateEmail(email)) {
            getView().incorrectEmail();
        } else {
            getView().loginSuccesful();
        }
    }

    /**
     * @param email Email to validate.
     * @param password Password to validate
     * @return String value.
     */
    public String validateCompleteFields(String email, String password) {
        if (email.isEmpty() && "".equals(password)) {
            return "c";
        } else {
            if ("".equals(email) && !"".equals(password)) {
                return "a";
            } else {
                if (!"".equals(email) && "".equals(password)) {
                    return "b";
                } else {
                    return "d";
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
