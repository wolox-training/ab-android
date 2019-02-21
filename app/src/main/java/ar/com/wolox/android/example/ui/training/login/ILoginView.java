package ar.com.wolox.android.example.ui.training.login;

/**
 * IloginView is used for user to Login
 */
public interface ILoginView {

    void loginSuccesful();

    void incompletePassword();

    void incompleteEmail();

    void incorrectEmail();

    void incorrectEmailPassword();

    void notInternet();

    void showProgressBar();

    void hideProgressBar();

}
