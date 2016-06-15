package edu.galileo.android.androidchat.chat;

/**
 * Created by Lab1 on 15/06/2016.
 */
public interface ChatRepository {
    void changeConnectionStatus(boolean online);

    void setChatRecipient(String recipient);
    void sendMessage(String msg);

    void subscribe();
    void unsubscribe();
    void destroyListener();
}
