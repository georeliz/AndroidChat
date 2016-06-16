package edu.galileo.android.androidchat.singup;

import org.greenrobot.eventbus.Subscribe;

import edu.galileo.android.androidchat.lib.EventBus;
import edu.galileo.android.androidchat.lib.GreenRobotEventBus;
import edu.galileo.android.androidchat.lib.events.LoginEvent;

/**
 * Created by Lab1 on 16/06/2016.
 */
public class SignUpPresenterImpl implements SignUpPresenter {
    private EventBus eventBus;
    private SignUpView view;
    private SignUpInteractor interactor;
    public SignUpPresenterImpl(SignUpView view) {
        this.view = view;
        interactor = new SignUpInteractorImpl();
        this.eventBus = GreenRobotEventBus.getInstace();
    }

    @Override
    public void onCreate() {
        eventBus.register(this);

    }

    @Override
    public void onDestroy() {
        view = null;
        eventBus.unregister(this);

    }

    @Override
    public void registerNewUser(String email, String password) {
        if (view != null){
            view.disableInputs();
            view.showProgress();
        }
        interactor.doSignUp(email, password);

    }

    @Override
    @Subscribe
    public void onEventMainThread(LoginEvent event) {
        switch (event.getEventType()){
            case LoginEvent.onSignUpErro:
                onSignUpError(event.getErrorMessage());
                break;
            case LoginEvent.onSignUpSuccess:
                onSignUpSuccess();
                break;
        }

    }
    private void onSignUpSuccess(){
        if (view != null){
            view.newUserSuccess();
        }
    }

    private void onSignUpError(String error){
        if (view !=null){
            view.hideProgress();
            view.enableInputs();
            view.newUserError(error);
        }
    }
}
