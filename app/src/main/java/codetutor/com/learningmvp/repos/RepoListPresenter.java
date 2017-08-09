package codetutor.com.learningmvp.repos;

import java.util.List;

import codetutor.com.learningmvp.models.Repo;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by anildeshpande on 8/9/17.
 */

public class RepoListPresenter implements IRepoListPresenter, OnRepoInteractorFinishedListener {

    private IRepoListView view;
    private RepoListInteractor interactor;

    public RepoListPresenter(IRepoListView view){
        this.view=view;
        this.interactor = new RepoListInteractor(this);

    }

    @Override
    public void onNetworkError(RetrofitError retrofitError) {
        view.onReposLoadedFailure(retrofitError);
    }

    @Override
    public void onNetworkSuccess(List<Repo> list, Response response) {
        view.onReposLoadedSuccess(list,response);
    }

    @Override
    public void loadCommits(String userName) {
        interactor.loadRecentCommits(userName);
    }
}
