package codetutor.com.learningmvp.login;

import java.lang.ref.WeakReference;

import codetutor.com.learningmvp.login.async.AsynchronousInteractor;

/**
 * Created by anildeshpande on 8/9/17.
 */

public class LoginPresenter implements ILoginPresenter, OnLoginFinishedListener{

    private WeakReference<ILoginView> iLoginView;
    private AsynchronousInteractor interactor;

    public LoginPresenter(ILoginView iLoginView){
        this.iLoginView = new WeakReference<ILoginView>(iLoginView);
        this.interactor = new AsynchronousInteractor();
    }

    public void attemptLogin(String username, String password){
        interactor.validateCredentailsAsync(this,username,password);
    }

    @Override
    public void onError() {
        if(iLoginView.get()!=null){
            iLoginView.get().loginFailed();
        }

    }

    @Override
    public void onSuccess() {
        if(iLoginView.get()!=null){
            iLoginView.get().navigateToListActivity();
        }
    }
}
