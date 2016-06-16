package edu.galileo.android.androidchat.singup;

/**
 * Created by Lab1 on 16/06/2016.
 */
public interface SignUpView {
    void enableInputs();
    void disableInputs();
    void showProgress();
    void hideProgress();

    void handleSignUp();

    void navigateToMainScreen();

    void newUserSuccess();
    void newUserError(String error);
}
