package edu.galileo.android.androidchat.contactlist;

/**
 * Created by Gerson on 11/06/2016.
 */
public interface ContactListInteractor {
    void subscribe();
    void unsubscribe();
    void destroyListener();
    void removeContact(String email);
}
