package codetutor.com.learningmvp.repos;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import codetutor.com.learningmvp.GithubService;
import codetutor.com.learningmvp.models.Repo;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by anildeshpande on 8/9/17.
 */

public class RepoListInteractor implements Callback<List<Repo>> {
    private OnRepoInteractorFinishedListener listener;

    public RepoListInteractor(OnRepoInteractorFinishedListener listener){
        this.listener=listener;
    }

    private RestAdapter initRestAdapter(){
        RestAdapter restAdapter=new RestAdapter.Builder().
                setLogLevel(RestAdapter.LogLevel.FULL)
                .setEndpoint("https://api.github.com")
                .build();
        return restAdapter;
    }

    public void loadRecentCommits(String username){
        RestAdapter restAdapter=initRestAdapter();
        restAdapter.create(GithubService.class).listRepos(username,this);
    }

    @Override
    public void failure(RetrofitError error) {
        listener.onNetworkError(error);
    }

    @Override
    public void success(List<Repo> repos, Response response) {
        Collections.sort(repos, new Comparator<Repo>() {
            @Override
            public int compare(Repo left, Repo right) {
                return left.stars>right.stars?-1: 1;
            }
        });
        listener.onNetworkSuccess(repos,response);
    }
}
