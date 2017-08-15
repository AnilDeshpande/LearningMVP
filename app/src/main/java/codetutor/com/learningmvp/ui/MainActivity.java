package codetutor.com.learningmvp.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import codetutor.com.learningmvp.BuildConfig;
import codetutor.com.learningmvp.R;
import codetutor.com.learningmvp.login.ILoginView;
import codetutor.com.learningmvp.login.LoginPresenter;
import codetutor.com.learningmvp.ui.fragments.RepoListFragment;

public class MainActivity extends AppCompatActivity implements ILoginView{

    @BindView(R.id.editTextEmailId) EditText editTextEmailId;

    @BindView(R.id.edittextPassword) EditText edittextPassword;

    @BindView(R.id.buttonLogin) Button buttonLogin;

    LoginPresenter loginPresenter;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        if(BuildConfig.DEBUG){
            editTextEmailId.setText("AnilDeshpande");
            edittextPassword.setText("anil");
        }

        loginPresenter = new LoginPresenter(this);

    }

    @OnClick(R.id.buttonLogin)
    public void loginTapped(View view){
        progressDialog=ProgressDialog.show(this,"Autheticating...",null);
        String email=editTextEmailId.getText().toString();
        String passord = edittextPassword.getText().toString();
        loginPresenter.attemptLogin(email,passord);
    }

    @Override
    public void navigateToListActivity() {
        progressDialog.dismiss();
        Toast.makeText(this,"Login Success!!",Toast.LENGTH_LONG).show();
        Intent i = new Intent(this, RepoListFragmentActivity.class);
        i.putExtra("userName", editTextEmailId.getText().toString());
        startActivity(i);
    }

    @Override
    public void loginFailed() {
        progressDialog.dismiss();
        Toast.makeText(this,"Login Failed!!",Toast.LENGTH_LONG).show();
    }
}
