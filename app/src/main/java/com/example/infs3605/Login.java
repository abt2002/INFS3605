package com.example.infs3605;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity {

    private EditText edUser;

    private EditText edPass;

    private Button stReg;

    private Button stLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edUser = findViewById(R.id.edUser);
        edPass = findViewById(R.id.edPass);
        stReg = findViewById(R.id.stReg);
        stLogin = findViewById(R.id.stLogin);

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

        Intent intent = new Intent(this, Main.class);
        startActivity(intent);
    }
}