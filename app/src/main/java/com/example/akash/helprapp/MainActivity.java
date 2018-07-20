package com.example.akash.helprapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView helpr,ngo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        helpr=(ImageView)findViewById(R.id.imageView7);
        ngo=(ImageView)findViewById(R.id.imageView8);
        helpr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent helprregister = new Intent(getApplicationContext(), helprregister.class);
                startActivity(helprregister);
            }
        });
        ngo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ngoregister = new Intent(getApplicationContext(),ngoregister.class);
                startActivity(ngoregister);
            }
        });
    }
}
