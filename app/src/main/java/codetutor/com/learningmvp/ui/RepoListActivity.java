package codetutor.com.learningmvp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
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
 * Created by anildeshpande on 8/9/17.
 */

public class RepoListActivity extends AppCompatActivity implements IRepoListView, AdapterView.OnItemClickListener{


    @BindView(R.id.listViewRepo)
    ListView listViewRepo;

    private RepoListPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repo_list);
        ButterKnife.bind(this);

        presenter = new RepoListPresenter(this);
        listViewRepo.setOnItemClickListener(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        Intent intent=getIntent();
        String username = intent.getExtras().getString("userName");
        presenter.loadCommits(username);
    }

    @Override
    public void onReposLoadedSuccess(List<Repo> list, Response response) {
        listViewRepo.setAdapter(new RepoAdapter(this,list));
    }

    @Override
    public void onReposLoadedFailure(RetrofitError retrofitError) {
        Toast.makeText(this,retrofitError.getLocalizedMessage(),Toast.LENGTH_LONG).show();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Repo repo=(Repo)adapterView.getAdapter().getItem(i);
        Toast.makeText(this,String.format("Forked = %b", repo.fork), Toast.LENGTH_LONG).show();
    }
}
