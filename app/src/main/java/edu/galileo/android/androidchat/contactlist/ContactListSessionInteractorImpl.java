package edu.galileo.android.androidchat.contactlist;

/**
 * Created by Gerson on 12/06/2016.
 */
public class ContactListSessionInteractorImpl implements ContactListSessionInteractor {
    private ContactListRepository listRepository;

    public ContactListSessionInteractorImpl() {
        listRepository = new ContactListRepositoryImpl();

    }

    @Override
    public void signOff() {
        listRepository.signOff();

    }

    @Override
    public String getCurrentUserEmail() {
        return listRepository.getCurrentUserEmail();
    }

    @Override
    public void changeConnectionStatus(boolean online) {
        listRepository.changeConnectionStatus(online);
    }
}
