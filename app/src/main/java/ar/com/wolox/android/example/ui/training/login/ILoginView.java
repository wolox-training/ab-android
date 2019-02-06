package ar.com.wolox.android.example.ui.training.login;

import okhttp3.ResponseBody;

/**
 * IloginView is used for user to Login
 */
public interface ILoginView {

    void loginSuccesful();
    void incompletePassword();
    void incompleteEmail();
    void incorrectEmail();
    void incorrectPassword();
    void userNotFound(ResponseBody responseBody);
    void callFailure();
}
