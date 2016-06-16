package edu.galileo.android.androidchat.login;

/**
 * Created by Lab1 on 09/06/2016.
 */
public interface LoginInteractor {
    void checkSession();

    void doSignIn(String email, String password);
}


