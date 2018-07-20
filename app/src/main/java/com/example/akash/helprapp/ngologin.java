package com.example.akash.helprapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ngologin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ngologin);
    }
    public void met(View view)
    {
        Intent obj=new Intent(this,ngomakeone.class);
        startActivity(obj);
    }
}
