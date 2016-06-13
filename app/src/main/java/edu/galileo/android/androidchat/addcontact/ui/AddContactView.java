package edu.galileo.android.androidchat.addcontact.ui;

/**
 * Created by Gerson on 12/06/2016.
 */
public interface AddContactView {
    void showInput();
    void hideInput();
    void showProgress();
    void hideProgress();

    void contactAdded();
    void contactNotAdded();
}
