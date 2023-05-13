package com.example.sendyouridea;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.sendyouridea.interfaces.IShareActivity;

public class ShareActivity extends AppCompatActivity implements IShareActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);
    }

    @Override
    public void shareClickBtn() {

    }
}