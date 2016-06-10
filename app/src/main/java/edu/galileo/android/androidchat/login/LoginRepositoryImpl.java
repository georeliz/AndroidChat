package edu.galileo.android.androidchat.login;

import android.util.Log;

import com.firebase.client.Firebase;

import edu.galileo.android.androidchat.domain.FirebaseHelper;
import edu.galileo.android.androidchat.lib.EventBus;
import edu.galileo.android.androidchat.lib.GreenRobotEventBus;
import edu.galileo.android.androidchat.lib.events.LoginEvent;

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
        postEvent(LoginEvent.onSignInSuccess);
    }

    @Override
    public void signUp(String email, String password) {
        postEvent(LoginEvent.onSignUpSuccess);

    }

    @Override
    public void checkSession() {
        postEvent(LoginEvent.onFailedToRecoverSession);
    }

    private void postEvent(int type, String errorMessage){
        LoginEvent loginEvent = new LoginEvent();
        loginEvent.setEventType(type);
        if (errorMessage != null){
            loginEvent.setErrorMessage(errorMessage);
        }

        EventBus eventBus = GreenRobotEventBus.getInstace();
        eventBus.post(loginEvent);
    }

    private void postEvent(int type){
        postEvent(type, null);

    }

}
