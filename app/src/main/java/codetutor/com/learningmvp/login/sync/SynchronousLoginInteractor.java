package codetutor.com.learningmvp.login.sync;

import codetutor.com.learningmvp.login.ILoginInteractor;

/**
 * Created by anildeshpande on 8/9/17.
 */

public class SynchronousLoginInteractor implements ISynchronousInteractor {
    public SynchronousLoginInteractor(){}

    public boolean validateCredentails(String username, String password){
        return username.contains("gmail");
    }
}
