package edu.galileo.android.androidchat.entities;

import java.util.Map;

/**
 * Created by Lab1 on 10/06/2016.
 */
public class User {
    String email;
    boolean online;
    Map<String, Boolean> contacts;
    public final static boolean ONLINE = true;
    public final static boolean OFFLINE = false;

    public User() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public Map<String, Boolean> getContacts() {
        return contacts;
    }

    public void setContacts(Map<String, Boolean> contacts) {
        this.contacts = contacts;
    }

    @Override
    public boolean equals(Object o) {
        boolean equal = false;

        if (o instanceof User){
            User user = (User)o;
            equal = this.email.equals(user.getEmail());
        }
        return equal;
    }
}
