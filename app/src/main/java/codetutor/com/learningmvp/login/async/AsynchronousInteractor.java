package codetutor.com.learningmvp.login.async;



import android.os.Handler;

import codetutor.com.learningmvp.login.OnLoginFinishedListener;

/**
 * Created by anildeshpande on 8/9/17.
 */

public class AsynchronousInteractor implements IAsynchronousInteractor {

    @Override
    public void validateCredentailsAsync(final OnLoginFinishedListener listener, final String username, final String password) {
        new Handler().postDelayed(new Runnable() {
            @Override public void run() {
                if (password.contains("anil")) {
                    listener.onSuccess();
                } else {
                    listener.onError();
                }
            }
        }, 2000);

    }
}
