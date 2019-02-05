package ar.com.wolox.android.example.ui.training.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import ar.com.wolox.android.R;
import ar.com.wolox.android.example.ui.training.homePage.HomePageActivity;
import ar.com.wolox.android.example.ui.training.signUp.SignUpActivity;
import ar.com.wolox.wolmo.core.fragment.WolmoFragment;
import butterknife.BindView;

/**
 * LoginFragment is used for user to Login
 */
public class LoginFragment extends WolmoFragment<LoginPresenter> implements ILoginView {

    @BindView(R.id.login_email_edittext) EditText mEmailEditText;
    @BindView(R.id.login_email_password) EditText mPasswordEditText;
    @BindView(R.id.login_button) Button mLoginButton;
    @BindView(R.id.signup_button) Button mSignupButton;

    @Override
    public int layout() {
        return R.layout.fragment_login;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void init() {
        sharedPreferencesGetInfo();
        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPresenter().validateFields(mEmailEditText.getText().toString(),
                        mPasswordEditText.getText().toString());
            }
        });
        mSignupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), SignUpActivity.class);
                startActivity(intent);
            }
        });
    }

    public static LoginFragment newInstance() {
        LoginFragment fragment = new LoginFragment();
        return fragment;
    }

    @Override
    public void loginSuccesful() {
        sharedPreferencesPutInfo();
        intentHomePage();
    }

    public void sharedPreferencesPutInfo() {
        SharedPreferences sharedPreferences = getContext().getSharedPreferences(getString(R.string.key_login), 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(getString(R.string.key_email), mEmailEditText.getText().toString());
        editor.putString(getString(R.string.key_password), mPasswordEditText.getText().toString());
        editor.commit();
    }

    public void sharedPreferencesGetInfo() {
        SharedPreferences sharedPreferences = getContext().getSharedPreferences(getString(R.string.key_login), 0);
        String sharedPreferencesEmail = sharedPreferences.getString(getString(R.string.key_email), null);
        String sharedPreferencesPassword = sharedPreferences.getString(getString(R.string.key_password), null);
        mEmailEditText.setText(sharedPreferencesEmail);
        mPasswordEditText.setText(sharedPreferencesPassword);
    }
    public void intentHomePage() {
        Intent intent = new Intent(getContext(), HomePageActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    @Override
    public void incompletePassword() {
        mPasswordEditText.setError(getString(R.string.mandatory_fields));
    }

    @Override
    public void incompleteEmail() {
        mEmailEditText.setError(getString(R.string.mandatory_fields));
    }

    @Override
    public void incorrectEmail() {
        mEmailEditText.setError(getString(R.string.example_email));
    }
}
