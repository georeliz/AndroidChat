package edu.galileo.android.androidchat.contactlist;

/**
 * Created by Gerson on 11/06/2016.
 */
public interface ContactListRepository {
    void signOff();
    String getCurrentUserEmail();
    void destroyListener();
    void subscribeToContactListEventes();
    void unsubscribeToContactListEventes();
    void removeContact(String email);
    void changeConnectionStatus(boolean online);


}
