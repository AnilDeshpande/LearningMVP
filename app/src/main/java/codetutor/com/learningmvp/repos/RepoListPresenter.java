package codetutor.com.learningmvp.repos;

import java.lang.ref.WeakReference;
import java.util.List;

import codetutor.com.learningmvp.models.Repo;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by anildeshpande on 8/9/17.
 */

public class RepoListPresenter implements IRepoListPresenter, OnRepoInteractorFinishedListener {

    private WeakReference<IRepoListView> view;
    private RepoListInteractor interactor;

    public RepoListPresenter(IRepoListView view){
        this.view=new WeakReference<IRepoListView>(view);
        this.interactor = new RepoListInteractor(this);

    }

    @Override
    public void onNetworkError(RetrofitError retrofitError) {
        if(view.get()!=null){
            view.get().onReposLoadedFailure(retrofitError);
        }
    }

    @Override
    public void onNetworkSuccess(List<Repo> list, Response response) {
        if(view.get()!=null){
            view.get().onReposLoadedSuccess(list,response);
        }

    }

    @Override
    public void loadCommits(String userName) {
        interactor.loadRecentCommits(userName);
    }
}
