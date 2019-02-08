package ar.com.wolox.android.example.ui.training.root;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import java.util.List;
import javax.inject.Inject;
import ar.com.wolox.android.R;
import ar.com.wolox.android.example.model.User;
import ar.com.wolox.android.example.network.LoginService;
import ar.com.wolox.android.example.ui.training.homePage.HomePageActivity;
import ar.com.wolox.android.example.ui.training.login.LoginActivity;
import ar.com.wolox.wolmo.core.activity.WolmoActivity;
import ar.com.wolox.wolmo.networking.retrofit.RetrofitServices;
import ar.com.wolox.wolmo.networking.retrofit.callback.NetworkCallback;
import okhttp3.ResponseBody;

/**
 *
 */
public class RootActivity extends WolmoActivity {

    protected String mEmail;
    protected String mPassword;
    @Inject protected RetrofitServices mRetrofitServices;

    @Override
    protected int layout() {
        return R.layout.activity_base;
    }

    @Override
    protected void init() {
        sharedPreferencesGetInfo();
        validateLoginToRest(mEmail, mPassword);
    }

    public void sharedPreferencesGetInfo() {
        SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.key_login), 0);
        String sharedPreferencesEmail = sharedPreferences.getString(getString(R.string.key_email), null);
        String sharedPreferencesPassword = sharedPreferences.getString(getString(R.string.key_password), null);
        mEmail = sharedPreferencesEmail;
        mPassword = sharedPreferencesPassword;
    }

    /**
     *
     * @param email email to validate to Rest
     * @param password password to validate to Rest
     */
    public void validateLoginToRest(String email, String password) {

        mRetrofitServices.getService(LoginService.class).getUserByEmail(email).enqueue(new NetworkCallback<List<User>>() {
            @Override
            public void onResponseSuccessful(@Nullable List<User> users) {
                if (users.size() == 0) {
                    goToLogIn();
                } else {
                    if (users.get(0).getPassword().equals(password)) {
                        goToHomePage();
                    } else {
                        goToLogIn();
                    }
                }
            }

            @Override
            public void onResponseFailed(@Nullable ResponseBody responseBody, int i) {
                goToLogIn();
            }

            @Override
            public void onCallFailure(Throwable throwable) {
                goToLogIn();
            }
        });
    }

    public void goToLogIn() {
        Intent intent = new Intent(this, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    public void goToHomePage() {
        Intent intent = new Intent(this, HomePageActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}
