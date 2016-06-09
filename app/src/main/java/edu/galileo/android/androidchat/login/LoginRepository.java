package edu.galileo.android.androidchat.login;

/**
 * Created by Lab1 on 09/06/2016.
 */
public interface LoginRepository {
    void signIn(String email, String password);
    void signUp(String email, String password);
    void checkSession();
}
