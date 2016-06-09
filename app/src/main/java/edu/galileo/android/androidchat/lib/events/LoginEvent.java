package edu.galileo.android.androidchat.lib.events;

/**
 * Created by Lab1 on 09/06/2016.
 */
public class LoginEvent {
    public final static int onSignInErro = 0;
    public final static int onSignUpErro = 1;
    public final static int onSignInSuccess = 2;
    public final static int onSignUpSuccess = 3;
    public final static int onFailedToRecoverSession= 4;

    private int eventType;
    private String errorMessage;

    public int getEventType() {
        return eventType;
    }

    public void setEventType(int eventType) {
        this.eventType = eventType;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

}
