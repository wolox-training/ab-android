package ar.com.wolox.android.example.model;

import com.google.gson.annotations.SerializedName;

/**
 *
 */
public class User {
    @SerializedName("email")
    private String email;
    @SerializedName("password")
    private String password;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
