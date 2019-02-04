package ar.com.wolox.android.example.ui.training.login;

import android.content.SharedPreferences;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import ar.com.wolox.android.R;
import ar.com.wolox.wolmo.core.fragment.WolmoFragment;
import butterknife.BindView;

/**
 * LoginFragment is used for user to Login
 */
public class LoginFragment extends WolmoFragment<LoginPresenter> implements ILoginView {
    @BindView(R.id.edittext_email) EditText editTextEmail;
    @BindView(R.id.edittext_password) EditText editTextPassword;
    @BindView(R.id.login_button) Button loginButton;
    @BindView(R.id.signup_button) Button signupButton;
    @Override
    public int layout() {
        return R.layout.fragment_login;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void init() {
        SharedPreferences sp1 = getContext().getSharedPreferences(getString(R.string.login), 0);
        String pemail = sp1.getString(getString(R.string.email), null);
        String ppass = sp1.getString(getString(R.string.password), null);
        editTextEmail.setText(pemail);
        editTextPassword.setText(ppass);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPresenter().validateFields(editTextEmail.getText().toString(), editTextPassword.getText().toString());
            }
        });
    }

    public static LoginFragment newInstance() {
        LoginFragment fragment = new LoginFragment();
        return fragment;
    }

    @Override
    public void loginSuccesful() {
        SharedPreferences sp = getContext().getSharedPreferences(getString(R.string.login), 0);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(getString(R.string.email), editTextEmail.getText().toString());
        editor.putString(getString(R.string.password), editTextPassword.getText().toString());
        editor.commit();
    }

    @Override
    public void incompletePassword() {
        editTextPassword.setError(getString(R.string.mandatory_fields));
    }

    @Override
    public void incompleteEmail() {
        editTextEmail.setError(getString(R.string.mandatory_fields));
    }

    @Override
    public void incorrectEmail() {
        editTextEmail.setError(getString(R.string.example_email));
    }
}
