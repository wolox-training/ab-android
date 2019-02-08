package ar.com.wolox.android.example.ui.training.login;

/**
 * IloginView is used for user to Login
 */
public interface ILoginView {

    void loginSuccesful();
    void incompletePassword();
    void incompleteEmail();
    void incorrectEmail();
    void incorrectPassword();
    void userNotFound();
    void notInternet();
    void showProgressBar();
    void hideProgressBar();
}
