package com.example.infs3605;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.infs3605.database.UserDatabaseSQLite;
import com.example.infs3605.model.Session;

public class Login extends AppCompatActivity {

    public static String sessionUsername;

    private EditText edUser;

    private EditText edPass;

    private Button stReg;

    private Button stLogin;

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edUser = findViewById(R.id.edUser);
        edPass = findViewById(R.id.edPass);
        stReg = findViewById(R.id.stReg);
        stLogin = findViewById(R.id.stLogin);
        imageView = findViewById(R.id.imageView);

        stReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRegister();
            }
        });

        stLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doLogin();
            }
        });
    }

    private void openRegister(){
        Intent intent = new Intent(this, Register.class);
        startActivity(intent);
    }

    private void doLogin(){
        String username = edUser.getText().toString();
        sessionUsername = username;
        String password = edPass.getText().toString();
        if (username.trim().equals("")) {
            Toast.makeText(getApplicationContext(), "Username cannot be null", Toast.LENGTH_LONG).show();
            return;
        }
        if (password.trim().equals("")) {
            Toast.makeText(getApplicationContext(), "Password cannot be null", Toast.LENGTH_LONG).show();
            return;
        }
        UserDatabaseSQLite sqLite = new UserDatabaseSQLite(getApplicationContext());
        Boolean success = sqLite.checkusernamepassword(username, password);
        if (success) {
            Session.setCurrent(username);
            Intent intent = new Intent(this, Main.class);
            startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(), "Username/password error", Toast.LENGTH_LONG).show();
        }

    }

    public static String getUsername(){
        return sessionUsername;
    }
}