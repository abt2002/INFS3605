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

import com.example.infs3605.adapter.SettingAdapter;
import com.example.infs3605.model.Link;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SettingFragment  extends Fragment {

    private static final String EMAIL = "email";
    private RecyclerView linkRv;
    private List<Link> links = new ArrayList<>();
    private SettingAdapter adapter;
    private CallbackManager callbackManager;

    private ImageView imageView;

    @Nullable

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root =  inflater.inflate(R.layout.fragment_setting, container, false);
        imageView = root.findViewById(R.id.imageView4);
        linkRv = root.findViewById(R.id.linkRv);
        callbackManager = CallbackManager.Factory.create();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linkRv.setLayoutManager(linearLayoutManager);
        adapter = new SettingAdapter(getContext(), links);
        links.add(new Link("Give Feedback", "https://forms.gle/SfwVsFvPaxmNFxU3A"));
        links.add(new Link("Report Bugs", "https://forms.gle/NXxBpTmKjRTGNtcQ9"));

        linkRv.setAdapter(adapter);

        // If you are using in a fragment, call loginButton.setFragment(this);

        // Callback registration

        return root;
    }
}
