package edu.galileo.android.androidchat.contactlist;

/**
 * Created by Gerson on 12/06/2016.
 */
public class ContactListInteractorImpl implements ContactListInteractor {
    ContactListRepository repository;

    public ContactListInteractorImpl() {
        repository = new ContactListRepositoryImpl();
    }

    @Override
    public void subscribe() {
        repository.subscribeToContactListEventes();

    }

    @Override
    public void unsubscribe() {
        repository.unsubscribeToContactListEventes();
    }

    @Override
    public void destroyListener() {
        repository.destroyListener();
    }

    @Override
    public void removeContact(String email) {
        repository.removeContact(email);
    }
}
