package com.example.infs3605;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.infs3605.adapter.MainAdapter;
import com.example.infs3605.model.Link;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainFragment  extends Fragment {

    private static final String EMAIL = "email";
    private RecyclerView linkRv;
    private List<Link> links = new ArrayList<>();
    private MainAdapter adapter;
    private LoginButton loginButton;
    private CallbackManager callbackManager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root =  inflater.inflate(R.layout.fragment_main, container, false);
        linkRv = root.findViewById(R.id.linkRv);
        callbackManager = CallbackManager.Factory.create();
        loginButton = root.findViewById(R.id.login_button);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linkRv.setLayoutManager(linearLayoutManager);
        adapter = new MainAdapter(getContext(), links);
        links.add(new Link("UNSW handbook", "https://www.handbook.unsw.edu.au/search"));
        links.add(new Link("myUNSW", "https://my.unsw.edu.au/"));
        links.add(new Link("UNSW Moodle", "https://moodle.telt.unsw.edu.au/my/courses.php"));
        links.add(new Link("UNSW Current Student", "https://www.student.unsw.edu.au/"));
        links.add(new Link("Check reference style", "https://www.citethisforme.com/"));
        links.add(new Link("GIVE (check your mark)", "https://cgi.cse.unsw.edu.au/~give/code/login.php?app=/~give/Student/give.php"));
        links.add(new Link("Academic Skills", "https://www.student.unsw.edu.au/plagiarism"));
        links.add(new Link("Contact UNSW", "https://www.unsw.edu.au/about-us/our-story/contact-us"));
        links.add(new Link("Google", "https://www.google.com/"));

        linkRv.setAdapter(adapter);

        loginButton.setReadPermissions(Arrays.asList(EMAIL));
        // If you are using in a fragment, call loginButton.setFragment(this);

        // Callback registration
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                // App code
            }

            @Override
            public void onCancel() {
                // App code
            }

            @Override
            public void onError(FacebookException exception) {
                exception.printStackTrace();
                // App code
            }
        });
        return root;
    }
}
