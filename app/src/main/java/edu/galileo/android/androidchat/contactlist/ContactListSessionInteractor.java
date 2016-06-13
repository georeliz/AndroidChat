package edu.galileo.android.androidchat.contactlist;

/**
 * Created by Gerson on 11/06/2016.
 */
public interface ContactListSessionInteractor {
    void signOff();
    String getCurrentUserEmail();
    void changeConnectionStatus(boolean online);
}
