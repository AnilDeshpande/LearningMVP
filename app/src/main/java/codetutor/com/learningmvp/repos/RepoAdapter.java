package codetutor.com.learningmvp.repos;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import codetutor.com.learningmvp.models.Repo;

/**
 * Created by anildeshpande on 8/9/17.
 */

public class RepoAdapter  extends BaseAdapter{

    private List<Repo> list;
    private Context context;

    public RepoAdapter(Context context, List<Repo> list){
        this.context = context;
        this.list=list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public long getItemId(int i) {
        return list.get(i).id;
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if(view!=null){
            viewHolder = new ViewHolder(view);
        }else{
            view = ((Activity)context).getLayoutInflater().inflate(android.R.layout.simple_list_item_1, viewGroup, false);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        }

        final Repo repo=list.get(i);
        viewHolder.text1.setText(String.format("%s - %d", repo.name, repo.stars));
        return view;
    }

    public static class ViewHolder{
        @BindView(android.R.id.text1)
        TextView text1;

        public ViewHolder(View view){
            ButterKnife.bind(this, view);
        }
    }
}
