package codetutor.com.learningmvp.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import codetutor.com.learningmvp.R;
import codetutor.com.learningmvp.repos.IRepoListView;
import codetutor.com.learningmvp.ui.fragments.RepoListFragment;

public class RepoListFragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repo_list_fragment);
    }
}
