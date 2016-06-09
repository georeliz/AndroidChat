package edu.galileo.android.androidchat.lib;

/**
 * Created by Lab1 on 09/06/2016.
 */
public interface EventBus {
    void register(Object suscriber);
    void unregister(Object suscriber);
    void post(Object event);
}
