package edu.galileo.android.androidchat.contactlist;

import org.greenrobot.eventbus.Subscribe;

import edu.galileo.android.androidchat.contactlist.events.ContactListEvent;
import edu.galileo.android.androidchat.contactlist.ui.ContactListView;
import edu.galileo.android.androidchat.entities.User;
import edu.galileo.android.androidchat.lib.EventBus;
import edu.galileo.android.androidchat.lib.GreenRobotEventBus;

/**
 * Created by Gerson on 12/06/2016.
 */
public class ContactListPresenterImpl implements ContactListPresenter {
        private EventBus eventBus;
        private ContactListView contactListView;
        private ContactListInteractor contactListInteractor;
        private ContactListSessionInteractor sessionInteractor;

    public ContactListPresenterImpl(ContactListView contactListView) {
        this.contactListView = contactListView;
        eventBus = GreenRobotEventBus.getInstace();
        this.contactListInteractor = new ContactListInteractorImpl();
        this.sessionInteractor = new ContactListSessionInteractorImpl();
    }

    @Override
    public void onResume() {
        sessionInteractor.changeConnectionStatus(User.ONLINE);
        contactListInteractor.subscribe();


    }

    @Override
    public void onPause() {
        sessionInteractor.changeConnectionStatus(User.OFFLINE);
        contactListInteractor.unsubscribe();

    }

    @Override
    public void onCreate() {
        eventBus.register(this);

    }

    @Override
    public void onDestroy() {
        eventBus.unregister(this);
        contactListInteractor.destroyListener();
        contactListView = null;

    }

    @Override
    public void signOff() {
        sessionInteractor.changeConnectionStatus(User.OFFLINE);
        contactListInteractor.unsubscribe();
        contactListInteractor.destroyListener();
        sessionInteractor.signOff();

    }

    @Override
    public String getCurrentUserEmail() {
        return sessionInteractor.getCurrentUserEmail();
    }

    @Override
    public void removeContact(String email) {
        contactListInteractor.removeContact(email);

    }

    @Override
    @Subscribe
    public void onEventMainThread(ContactListEvent event) {
        User user = event.getUser();
        switch (event.getEventType()){
            case ContactListEvent.onContactAdded:
                onContactAdded(user);
                break;
            case ContactListEvent.onContactChanged:
                onContactChanged(user);
                break;
            case ContactListEvent.onContactRemoved:
                onContactRemoved(user);
                break;

        }

    }

    private void onContactAdded(User user){

        if (contactListView != null){
            contactListView.onContactAdded(user);
        }
    }

    private void onContactChanged(User user){

        if (contactListView != null){
            contactListView.onContactChanged(user);
        }
    }

    private void onContactRemoved(User user){

        if (contactListView != null){
            contactListView.onContactRemoved(user);
        }
    }
}
