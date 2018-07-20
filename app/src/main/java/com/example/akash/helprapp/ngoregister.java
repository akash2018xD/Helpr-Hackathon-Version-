package com.example.akash.helprapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

public class ngoregister extends AppCompatActivity {
    String[] cities = {"Delhi/NCR", "Mumbai", "Kolkata", "Hyderabad", "Bangalore"};
    EditText name;
    EditText about;
    EditText address;
    AutoCompleteTextView city;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ngoregister);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this,android.R.layout.select_dialog_item,cities);
        AutoCompleteTextView actv= (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView2);
        actv.setThreshold(1);//will start working from first character
        actv.setAdapter(adapter);//setting the adapter data into the AutoCompleteTextView

        //grtting the valuse of the fields

        name=(EditText)findViewById(R.id.editText6);
        about=(EditText)findViewById(R.id.editText8);
        address=(EditText)findViewById(R.id.editText9);
        city=(AutoCompleteTextView)findViewById(R.id.autoCompleteTextView2);
    }
    public void ngologin(View view){
        Intent ngologin=new Intent(getApplicationContext(),ngologin.class);
        startActivity(ngologin);
    }
    public void next(View view){
        String nameVal= name.getText().toString();
        String aboutVal= about.getText().toString();
        String addressVal= address.getText().toString();
        String cityVal= city.getText().toString();
        if(!Objects.equals(nameVal,"") && !Objects.equals(aboutVal,"") && !Objects.equals(addressVal,"") && !Objects.equals(cityVal,"")) {
            Intent ngonext=new Intent(getApplicationContext(),ngoregisterextra.class);
            ngonext.putExtra("nameVal",nameVal);
            ngonext.putExtra("aboutVal",aboutVal);
            ngonext.putExtra("addressVal",addressVal);
            ngonext.putExtra("cityVal",cityVal);
            startActivity(ngonext);
        }else{
            Toast.makeText(ngoregister.this,"You missed some field(s)!",Toast.LENGTH_LONG).show();
        }
    }
}
