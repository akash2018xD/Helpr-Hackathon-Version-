package com.example.akash.helprapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;

public class ngoregisterextra extends AppCompatActivity {
    EditText mail;
    EditText password;
    EditText phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ngoregisterextra);
        phone=(EditText)findViewById(R.id.editText10);
        mail=(EditText)findViewById(R.id.editText7);
        password=(EditText)findViewById(R.id.editText8);
    }
    public void ngoregister(View view){
        String phoneVal=phone.getText().toString();
        final String mailVal=mail.getText().toString();
        String passwordVal=password.getText().toString();
        String nameVal=getIntent().getStringExtra("nameVal");
        String aboutVal=getIntent().getStringExtra("aboutVal");
        String addressVal=getIntent().getStringExtra("addressVal");
        String cityVal=getIntent().getStringExtra("cityVal");

        if(!Objects.equals(mailVal,"") && !Objects.equals(passwordVal,"") && !Objects.equals(nameVal,"") && !Objects.equals(aboutVal,"") && !Objects.equals(addressVal,"") && !Objects.equals(cityVal,"")){
            //String toast="mail>"+mailVal+" password>"+passwordVal+" name>"+nameVal+" about>"+aboutVal+" address>"+addressVal+" city>"+cityVal;
            //Toast.makeText(ngoregisterextra.this,"Correct Values",Toast.LENGTH_LONG).show();
            // Instantiate the RequestQueue.
            RequestQueue queue = Volley.newRequestQueue(this);
            //string of url which refers to the php code
            String url = "http://192.168.225.44/helpr/ngoregister.php?name="+nameVal+"&about="+aboutVal+"&city="+cityVal+"&address="+addressVal+"&phone="+phoneVal+"&mail="+mailVal+"&password="+passwordVal;

// Request a string response from the provided URL.
            StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            // Display the first 500 characters of the response string.

                            JSONObject success = null;
                            try {
                                success = new JSONObject(response);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            Boolean flag = null;
                            try {
                                flag = success.getBoolean("success");
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            if (flag == true) {
                                Toast.makeText(ngoregisterextra.this, "Registered!", Toast.LENGTH_LONG).show();
                                Intent ngoanimalselect=new Intent(getApplicationContext(),ngoanimalselect.class);
                                ngoanimalselect.putExtra("mailVal",mailVal);
                                startActivity(ngoanimalselect);
                                finish();
                            } else {
                                Toast.makeText(ngoregisterextra.this, "Could not register!", Toast.LENGTH_LONG).show();
                            }
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });

// Add the request to the RequestQueue.
            queue.add(stringRequest);
        }else {
            Toast.makeText(ngoregisterextra.this,"You missed some field(s)!",Toast.LENGTH_LONG).show();
        }

    }
}
