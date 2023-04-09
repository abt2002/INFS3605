package com.example.infs3605;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.infs3605.database.Details;
import com.example.infs3605.database.DetailsDatabaseSQLite;

public class DetailEdit extends AppCompatActivity {

    private static final String TAG = DetailEdit.class.getSimpleName();

    private EditText deFaculty;
    private EditText deCourse1;
    private EditText deCourse2;
    private EditText deCourse3;
    private Button deSub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_edit);
        deFaculty = this.findViewById(R.id.deFaculty);
        deCourse1 = this.findViewById(R.id.deCourse1);
        deCourse2 = this.findViewById(R.id.deCourse2);
        deCourse3 = this.findViewById(R.id.deCourse3);
        deSub = this.findViewById(R.id.deSub);

    //Submits the new user details
        deSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = Login.getUsername();
                String faculty = deFaculty.getText().toString();
                String coursea = deCourse1.getText().toString();
                String courseb = deCourse2.getText().toString();
                String coursec = deCourse3.getText().toString();

                DetailsDatabaseSQLite sqLite = new DetailsDatabaseSQLite(getApplicationContext());
                //Check if user details already exist
                try {
                    sqLite.insertData(username, faculty, coursea, courseb, coursec);
                } catch (Exception e) {
                    sqLite.updateData(username, faculty, coursea, courseb, coursec);
                    Details details = sqLite.selectDetails(username);
                    Toast.makeText(getApplicationContext(), details.getFaculty(), Toast.LENGTH_LONG).show();
                }

                Details details = sqLite.selectDetails(username);
            }
        });


    }
}