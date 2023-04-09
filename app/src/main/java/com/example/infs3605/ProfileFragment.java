package com.example.infs3605;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.infs3605.database.Details;
import com.example.infs3605.database.DetailsDatabaseSQLite;

import com.example.infs3605.databinding.FragmentProfileBinding;

import java.io.IOException;

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

        DetailsDatabaseSQLite sqLite = new DetailsDatabaseSQLite(getActivity().getApplicationContext());

        Details details = sqLite.selectDetails(Login.getUsername());

        try {
            txtFaculty.setText(details.getFaculty());
            txtCourseA.setText(details.getCoursea());
            txtCourseB.setText(details.getCourseb());
            txtCourseC.setText(details.getCoursec());
            Toast.makeText(getActivity().getApplicationContext(), details.getFaculty(), Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            //ignore
            //Toast.makeText(getActivity().getApplicationContext(),"failed",Toast.LENGTH_LONG).show();
        }

        try {
            Toast.makeText(getActivity().getApplicationContext(), details.getFaculty(), Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Toast.makeText(getActivity().getApplicationContext(), "failed to get faculty", Toast.LENGTH_LONG).show();
        }


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
