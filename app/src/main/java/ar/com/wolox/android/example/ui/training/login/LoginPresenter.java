package ar.com.wolox.android.example.ui.training.login;

import android.support.annotation.Nullable;
import android.util.Patterns;
import java.util.List;
import javax.inject.Inject;
import ar.com.wolox.android.example.model.User;
import ar.com.wolox.android.example.network.LoginService;
import ar.com.wolox.wolmo.core.presenter.BasePresenter;
import ar.com.wolox.wolmo.networking.retrofit.RetrofitServices;
import ar.com.wolox.wolmo.networking.retrofit.callback.NetworkCallback;
import okhttp3.ResponseBody;

/**
 * LoginPresenter is used for user to Login
 */
public class LoginPresenter extends BasePresenter<ILoginView> {

    @Inject
    RetrofitServices mRetrofitServices;

    @Inject
    public LoginPresenter(RetrofitServices retrofitServices) {
        mRetrofitServices = retrofitServices;
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
            validateLoginToRest(email, password);
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

    /**
     *
     * @param email email to validate to rest
     * @param password password to validate to rest
     */
    public void validateLoginToRest(String email, String password) {

        mRetrofitServices.getService(LoginService.class).getUserByEmail(email).enqueue(new NetworkCallback<List<User>>() {
            @Override
            public void onResponseSuccessful(@Nullable List<User> users) {
                if (users.size() == 0) {
                    getView().userNotFound();
                } else {
                    if (users.get(0).getPassword().equals(password)) {
                        getView().loginSuccesful();
                    } else {
                        getView().incorrectPassword();
                    }
                }

            }

            @Override
            public void onResponseFailed(@Nullable ResponseBody responseBody, int i) {
                getView().userNotFound();
            }

            @Override
            public void onCallFailure(Throwable throwable) {
                getView().callFailure();
            }
        });
    }
}
