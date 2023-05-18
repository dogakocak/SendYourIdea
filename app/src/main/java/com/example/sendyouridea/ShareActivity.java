package com.example.sendyouridea;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sendyouridea.interfaces.IShareActivity;

public class ShareActivity extends AppCompatActivity implements IShareActivity {

    // editText for writing comments
    private EditText commentTxt;
    // textView for storing the profile information
    private TextView profileTxt;
    // Simple share button
    private Button shareBtn;
    // ImageView for profile picture hold the profile pic image
    private ImageView profilePic;

    private static final String KEY_USERNAME = "username";

    private String username;

    private SharedPreferences sp;

    private static final String SHARED_PREF_NAME = "LoginInfo";

    private SharedPreferences.Editor spEditor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);
        commentTxt = findViewById(R.id.commentText);
        profileTxt = findViewById(R.id.profileInfo);
        shareBtn = findViewById(R.id.shareButton);
        profilePic = findViewById(R.id.profileView);
        sp = getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);
        spEditor = sp.edit();
        username = sp.getString(KEY_USERNAME,null);
        profileTxt.setText(username);
    }

    @Override
    public void shareClickBtn() {

    }
}