package edu.galileo.android.androidchat.singup;

import edu.galileo.android.androidchat.login.LoginRepository;
import edu.galileo.android.androidchat.login.LoginRepositoryImpl;

/**
 * Created by Lab1 on 16/06/2016.
 */
public class SignUpInteractorImpl implements SignUpInteractor {

    private LoginRepository repository;

    public SignUpInteractorImpl() {
        this.repository = new LoginRepositoryImpl();
    }

    @Override
    public void doSignUp(String email, String password) {
        repository.signUp(email,password);
    }
}
