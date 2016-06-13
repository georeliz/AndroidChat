package edu.galileo.android.androidchat.contactlist;

import edu.galileo.android.androidchat.contactlist.events.ContactListEvent;

/**
 * Created by Gerson on 11/06/2016.
 */
public interface ContactListPresenter {
    void onResume();
    void onPause();
    void onCreate();
    void onDestroy();

    void signOff();
    String getCurrentUserEmail();
    void removeContact(String email);
    void onEventMainThread(ContactListEvent event);

}
