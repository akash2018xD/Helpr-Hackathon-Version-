package com.example.akash.helprapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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


public class helprlogin extends AppCompatActivity {
    EditText mail;
    EditText password;
    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helprlogin);
        mail=(EditText)findViewById(R.id.editText5);
        password=(EditText)findViewById(R.id.editText6);
    }
    public void userlogin(View view){
        String mailVal=mail.getText().toString();
        String passwordVal=password.getText().toString();
        if(mailVal!=null && passwordVal!=null){
            // Login php part is commented
            //start
            /*
            RequestQueue queue = Volley.newRequestQueue(this);
            //string of url which refers to the php code
            String url = "http://192.168.225.44/helpr/helprlogin.php?mail="+mailVal+"&password="+passwordVal;

// Request a string response from the provided URL.
            StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            // Display the first 500 characters of the response string.
                            JSONObject success = null;
                            try {
                                success=new JSONObject(response);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            Boolean flag=null;
                            try {
                                flag=success.getBoolean("success");
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            if(flag==true){
                                Toast.makeText(helprlogin.this, "Correct!", Toast.LENGTH_LONG).show();
                                prefs=getSharedPreferences("flag",0);
                                editor=prefs.edit();
                                editor.putInt("flag",1);
                                editor.commit();
                                Intent userone=new Intent(getApplicationContext(),userone.class);
                                startActivity(userone);
                                finish();
                            }else {
                                Toast.makeText(helprlogin.this, "Mail/Password Incorrect!", Toast.LENGTH_LONG).show();
                            }

                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });

// Add the request to the RequestQueue.
            queue.add(stringRequest);
/*
//end
 */
            Intent userone=new Intent(getApplicationContext(),userone.class);
            startActivity(userone);
            finish();
        }else {
            Toast.makeText(helprlogin.this, "Could not register!", Toast.LENGTH_LONG).show();
        }
    }
}
