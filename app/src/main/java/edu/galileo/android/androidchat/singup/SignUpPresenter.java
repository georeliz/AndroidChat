package edu.galileo.android.androidchat.singup;

import edu.galileo.android.androidchat.lib.events.LoginEvent;

/**
 * Created by Lab1 on 16/06/2016.
 */
public interface SignUpPresenter {
    void onCreate();
    void onDestroy();

    void registerNewUser(String email, String password);
    void onEventMainThread(LoginEvent event);
}
