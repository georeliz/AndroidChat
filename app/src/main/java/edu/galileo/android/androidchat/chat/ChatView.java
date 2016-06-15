package edu.galileo.android.androidchat.chat;

import edu.galileo.android.androidchat.entities.ChatMessage;

/**
 * Created by Lab1 on 15/06/2016.
 */
public interface ChatView {
    void onMessageRecived(ChatMessage msg);
}
