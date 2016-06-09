package edu.galileo.android.androidchat.login;

import android.util.Log;

import com.firebase.client.Firebase;

import edu.galileo.android.androidchat.domain.FirebaseHelper;

/**
 * Created by Lab1 on 09/06/2016.
 */
public class LoginRepositoryImpl implements LoginRepository {
    private FirebaseHelper helper;

    public LoginRepositoryImpl() {
        this.helper = FirebaseHelper.getInstance();
    }

    @Override
    public void signIn(String email, String password) {
        Log.e("LoginRepositoryImpl", "sign in");
    }

    @Override
    public void signUp(String email, String password) {
        Log.e("LoginRepositoryImpl", "sign up");

    }

    @Override
    public void checkSession() {
        Log.e("LoginRepositoryImpl", "check session");
    }
}
