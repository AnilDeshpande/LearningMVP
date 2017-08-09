package codetutor.com.learningmvp.repos;

import java.util.List;

import codetutor.com.learningmvp.models.Repo;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by anildeshpande on 8/9/17.
 */

public interface IRepoListView {
    void onReposLoadedSuccess(List<Repo> list, Response response);
    void onReposLoadedFailure(RetrofitError retrofitError);
}
