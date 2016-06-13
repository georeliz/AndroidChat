package edu.galileo.android.androidchat.addcontact;

/**
 * Created by Gerson on 12/06/2016.
 */
public class AddContactInteractorImpl implements AddContactInteractor {
    private AddContactRepository repository;

    public AddContactInteractorImpl() {
        repository = new AddContactRepositoryImpl();
    }

    @Override
    public void execute(String email) {
        repository.addContact(email);
    }
}
