package ar.com.wolox.android.example.ui.training.login;
/**
 * IloginView is used for user to Login
 */
public interface ILoginView {

    void loginSuccesful();
    void incompleteFields(String s);
    void incorrectEmail();
}
