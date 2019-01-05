package com.example.alaba.retrofittest.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.alaba.retrofittest.R;
import com.example.alaba.retrofittest.storage.SPManager;

import java.util.Timer;
import java.util.TimerTask;

public class BannerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner);

        final boolean isLoggedIn = SPManager.getInstance(this).isLogged();

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent;

                if (isLoggedIn){
                    intent = new Intent(BannerActivity.this, ProfileActivity.class);
                }
                else{
                    intent = new Intent(BannerActivity.this, LoginActivity.class);
                }
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        }, 2000);

    }
}
