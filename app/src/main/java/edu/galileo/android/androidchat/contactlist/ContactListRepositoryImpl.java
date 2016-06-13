package edu.galileo.android.androidchat.contactlist;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.FirebaseError;

import edu.galileo.android.androidchat.contactlist.events.ContactListEvent;
import edu.galileo.android.androidchat.contactlist.ui.ContactListView;
import edu.galileo.android.androidchat.domain.FirebaseHelper;
import edu.galileo.android.androidchat.entities.User;
import edu.galileo.android.androidchat.lib.EventBus;
import edu.galileo.android.androidchat.lib.GreenRobotEventBus;

/**
 * Created by Gerson on 12/06/2016.
 */
public class ContactListRepositoryImpl implements ContactListRepository {
    private EventBus eventBus;
    private FirebaseHelper helper;
    private ChildEventListener contactEventListener;

    public ContactListRepositoryImpl() {
        this.eventBus = GreenRobotEventBus.getInstace();
        this.helper = FirebaseHelper.getInstance();
    }

    @Override
    public void signOff() {
        helper.signoff();
    }

    @Override
    public String getCurrentUserEmail() {
        return helper.getAuthUserEmail();
    }

    @Override
    public void destroyListener() {
        contactEventListener = null;

    }

    @Override
    public void subscribeToContactListEventes() {
        if (contactEventListener ==null){
            contactEventListener = new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                    handleContact(dataSnapshot, ContactListEvent.onContactAdded);
                }

                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                    handleContact(dataSnapshot, ContactListEvent.onContactChanged);

                }

                @Override
                public void onChildRemoved(DataSnapshot dataSnapshot) {
                    handleContact(dataSnapshot, ContactListEvent.onContactRemoved);

                }

                @Override
                public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            };

        }
        helper.getMyContactsReference().addChildEventListener(contactEventListener);


    }

    private void handleContact(DataSnapshot dataSnapshot, int type) {
        String email = dataSnapshot.getKey();
        email = email.replace("_",".");
        boolean online = ((Boolean) dataSnapshot.getValue()).booleanValue();
        User user = new User();
        user.setEmail(email);
        user.setOnline(online);
        post(type, user);
    }

    private void post(int type, User user) {
        ContactListEvent event = new ContactListEvent();
        event.setEventType(type);
        event.setUser(user);
        eventBus.post(event);

    }

    @Override
    public void unsubscribeToContactListEventes() {
        if (contactEventListener != null){
            helper.getMyContactsReference().removeEventListener(contactEventListener);
        }

    }

    @Override
    public void removeContact(String email) {
        String currentUserEmail = helper.getAuthUserEmail();
        helper.getOneContactsReference(currentUserEmail, email).removeValue();
        helper.getOneContactsReference(email, currentUserEmail).removeValue();

    }

    @Override
    public void changeConnectionStatus(boolean online) {

    }
}