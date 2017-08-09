package codetutor.com.learningmvp.login.async;

import codetutor.com.learningmvp.login.OnLoginFinishedListener;

/**
 * Created by anildeshpande on 8/9/17.
 */

public interface IAsynchronousInteractor {
    void validateCredentailsAsync(OnLoginFinishedListener listener, String username, String password);
}
