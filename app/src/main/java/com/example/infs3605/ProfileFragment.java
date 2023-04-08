package com.example.infs3605;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.infs3605.databinding.FragmentProfileBinding;

public class ProfileFragment extends Fragment {

    private TextView txtName;
    private TextView txtFaculty;
    private TextView txtCourseA;
    private TextView txtCourseB;
    private TextView txtCourseC;

    private Button btEdit;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root =  inflater.inflate(R.layout.fragment_profile, container, false);
        txtName = root.findViewById(R.id.txtName);
        txtFaculty = root.findViewById(R.id.txtFaculty);
        txtCourseA = root.findViewById(R.id.txtCourseA);
        txtCourseB = root.findViewById(R.id.txtCourseB);
        txtCourseC = root.findViewById(R.id.txtCourseC);
        btEdit = root.findViewById(R.id.btEdit);

        btEdit.setOnClickListener(new View.OnClickListener() {
            //Switch to the detail edit screen.
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(ProfileFragment.this.getActivity(), DetailEdit.class);
                startActivity(myIntent);
            }
        });

        return root;
    }

}
