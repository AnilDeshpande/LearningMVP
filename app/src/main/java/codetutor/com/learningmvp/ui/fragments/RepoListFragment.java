package codetutor.com.learningmvp.ui.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import codetutor.com.learningmvp.R;
import codetutor.com.learningmvp.models.Repo;
import codetutor.com.learningmvp.repos.IRepoListView;
import codetutor.com.learningmvp.repos.RepoAdapter;
import codetutor.com.learningmvp.repos.RepoListPresenter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class RepoListFragment extends Fragment implements IRepoListView{

    public RepoListFragment() {
        // Required empty public constructor
    }

    @BindView(R.id.listViewRepoFragment)
    ListView listViewRepoFragment;

    private RepoListPresenter presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new RepoListPresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_repo_list,container,false);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.loadCommits("AnilDeshpande");
    }

    @Override
    public void onReposLoadedSuccess(List<Repo> list, Response response) {
        listViewRepoFragment.setAdapter(new RepoAdapter(getActivity(),list));
    }

    @Override
    public void onReposLoadedFailure(RetrofitError retrofitError) {
        Toast.makeText(getActivity(),retrofitError.getLocalizedMessage(),Toast.LENGTH_SHORT).show();
    }
}
