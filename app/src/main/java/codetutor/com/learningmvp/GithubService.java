package codetutor.com.learningmvp;

import java.util.List;

import codetutor.com.learningmvp.models.Repo;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by anildeshpande on 8/9/17.
 */

public interface GithubService {
    @GET("/users/{user}/repos")
    void listRepos(@Path("user") String user, Callback<List<Repo>> callback);
}
