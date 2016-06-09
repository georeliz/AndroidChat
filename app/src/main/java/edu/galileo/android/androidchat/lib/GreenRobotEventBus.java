package edu.galileo.android.androidchat.lib;

/**
 * Created by Lab1 on 09/06/2016.
 */
public class GreenRobotEventBus implements EventBus {

    de.greenrobot.event.EventBus eventBus;

    private static class SingletonHolder{
        private static final GreenRobotEventBus INSTACE = new GreenRobotEventBus();
    }

    public static GreenRobotEventBus getInstace(){
        return SingletonHolder.INSTACE;
    }

    public GreenRobotEventBus() {
        this.eventBus = de.greenrobot.event.EventBus.getDefault();
    }

    @Override
    public void register(Object suscriber) {
        eventBus.register(suscriber);
    }

    @Override
    public void unregister(Object suscriber) {
        eventBus.unregister(suscriber);
    }

    @Override
    public void post(Object event) {
        eventBus.post(event);
    }
}
