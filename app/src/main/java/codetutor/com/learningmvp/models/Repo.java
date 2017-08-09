package codetutor.com.learningmvp.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by anildeshpande on 8/9/17.
 */

public class Repo {
    public int id;
    public String name;
    public boolean fork;
    @SerializedName("stargazers_count")
    public int stars;
}
