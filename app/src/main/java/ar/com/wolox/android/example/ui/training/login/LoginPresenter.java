package ar.com.wolox.android.example.ui.training.login;

import android.util.Patterns;
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
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            getView().incorrectEmail();
        } else {
            getView().loginSuccesful();
        }
    }

    /**
     * @param email Email to validate if is empty.
     * @param password Password to validate if is empty
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
}
