package com.example.sendyouridea;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String username,password;
    private Button loginBtn;
    private EditText usernameInput,passwordInput;
    private SharedPreferences sp;
    private SharedPreferences.Editor spEditor;

    private static final String DB_USERNAME = "admin";
    private static final String DB_PASSWORD = "admin";
    private static final String SHARED_PREF_NAME = "LoginInfo";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_PASSWORD = "password";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usernameInput = findViewById(R.id.usernameInput);
        passwordInput = findViewById(R.id.passwordInput);
        loginBtn = findViewById(R.id.loginBtn);
        sp = getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);
        spEditor = sp.edit();
        username = sp.getString(KEY_USERNAME,null);
        password = sp.getString(KEY_PASSWORD, null);
        checkField(null);
    }
    public void checkField(View view){
        if (username == null) username = usernameInput.getText().toString();
        if (password == null) password = passwordInput.getText().toString();
        Log.d("USERNAME:",username);
        Log.d("PASSWORD:",password);
        if (username.equals(DB_USERNAME) && password.equals(DB_PASSWORD)){
            spEditor.putString(KEY_USERNAME,username);
            spEditor.putString(KEY_PASSWORD,password);
            spEditor.commit();
            Toast.makeText(this, "Login is successfull", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, ShareActivity.class));
        }else{
            if (view != null) Toast.makeText(this, "Username or password is incorrect", Toast.LENGTH_SHORT).show();
        }
    }
}