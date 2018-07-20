package com.example.akash.helprapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

public class Splash extends AppCompatActivity {
    int flag=0;
    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);
        prefs=getSharedPreferences("flag",MODE_PRIVATE);
        editor=prefs.edit();
        flag=prefs.getInt("flag",0);
        Thread obj = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(1000); //setting splash screen time in millisecs
                    if (flag == 0) {
                        Intent obj2 = new Intent(getApplicationContext(),userone.class);
                        startActivity(obj2);
                    }
                    else if(flag==1)
                    {
                        Intent obj2=new Intent(getApplicationContext(),userone.class);
                        startActivity(obj2);
                    }
                    else if(flag==2)
                    {
                        //code for ngo
                    }
                    finish();
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        obj.start();
    }
}
