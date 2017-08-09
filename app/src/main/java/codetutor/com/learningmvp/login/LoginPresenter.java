package codetutor.com.learningmvp.login;

import codetutor.com.learningmvp.login.async.AsynchronousInteractor;

/**
 * Created by anildeshpande on 8/9/17.
 */

public class LoginPresenter implements ILoginPresenter, OnLoginFinishedListener{

    private ILoginView iLoginView;
    private AsynchronousInteractor interactor;

    public LoginPresenter(ILoginView iLoginView){
        this.iLoginView = iLoginView;
        this.interactor = new AsynchronousInteractor();
    }

    public void attemptLogin(String username, String password){
        interactor.validateCredentailsAsync(this,username,password);
    }

    @Override
    public void onError() {
        iLoginView.loginFailed();
    }

    @Override
    public void onSuccess() {
        iLoginView.navigateToListActivity();
    }
}
