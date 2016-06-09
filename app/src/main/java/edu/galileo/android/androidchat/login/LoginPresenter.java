package edu.galileo.android.androidchat.login;

/**
 * Created by Lab1 on 09/06/2016.
 */
public interface LoginPresenter {
    void onDestroy();

    void checkForAuthenticatedUser();
    void validateLogin(String email, String password);
    void registerNewUser(String email, String password);
}
