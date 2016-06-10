package edu.galileo.android.androidchat.login;

import edu.galileo.android.androidchat.lib.events.LoginEvent;

/**
 * Created by Lab1 on 09/06/2016.
 */
public interface LoginPresenter {
    void onCreate();
    void onDestroy();

    void checkForAuthenticatedUser();
    void validateLogin(String email, String password);
    void registerNewUser(String email, String password);
    void onEventMainThread(LoginEvent event);
}
