package com.example.infs3605;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.infs3605.database.UserDatabaseSQLite;

public class Register extends AppCompatActivity {

    private EditText edUser;

    private EditText edPass, edPass2;

    private Button reReg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edUser = findViewById(R.id.edUser);
        edPass = findViewById(R.id.edPass);
        edPass2 = findViewById(R.id.edPass2);
        reReg = findViewById(R.id.reReg);

        reReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edUser.getText().toString();
                String password = edPass.getText().toString();
                String password2 = edPass2.getText().toString();
                if (username.trim().equals("")) {
                    Toast.makeText(getApplicationContext(), "username not be null", Toast.LENGTH_LONG).show();
                    return;
                }
                if (password.trim().equals("")) {
                    Toast.makeText(getApplicationContext(), "password not be null", Toast.LENGTH_LONG).show();
                    return;
                }
                if (!password.equals(password2)) {
                    Toast.makeText(getApplicationContext(), "password are not equal", Toast.LENGTH_LONG).show();
                    return;
                }

                UserDatabaseSQLite sqLite = new UserDatabaseSQLite(getApplicationContext());
                Boolean exist = sqLite.checkusername(username);
                if (exist) {
                    Toast.makeText(getApplicationContext(), "username exist", Toast.LENGTH_LONG).show();
                } else {
                    Boolean success = sqLite.insertData(username, password, "brown", "james", "demo@gmail.com");
                    if (success) {
                        Toast.makeText(getApplicationContext(), "register success", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "register failed", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}