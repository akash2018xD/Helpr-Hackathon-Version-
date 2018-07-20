package com.example.akash.helprapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;

public class helprregister extends AppCompatActivity {
    String[] cities = {"Delhi/NCR", "Mumbai", "Kolkata", "Hyderabad", "Bangalore"};
    EditText name;
    EditText mail;
    EditText phone;
    AutoCompleteTextView city;
    EditText password;
    SharedPreferences sharedPref;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helprregister);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.select_dialog_item, cities);
        AutoCompleteTextView auto = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
        auto.setThreshold(1);
        auto.setAdapter(adapter);
        name = (EditText) findViewById(R.id.editText);
        mail = (EditText) findViewById(R.id.editText2);
        phone = (EditText) findViewById(R.id.editText3);
        city = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
        password = (EditText) findViewById(R.id.editText4);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public void login(View view) {
        sharedPref = getSharedPreferences("flag",MODE_PRIVATE);
        int flag=sharedPref.getInt("flag",0);
        Intent helprlogin=new Intent(getApplicationContext(),helprlogin.class);
        startActivity(helprlogin);
        if(flag!=0){
            finish();
        }
    }

    public void register(View view) {

        String nameVal = name.getText().toString();
        String mailVal = mail.getText().toString();
        String phoneVal = phone.getText().toString();
        String cityVal = city.getText().toString();
        String passwordVal = password.getText().toString();
        if (!Objects.equals(nameVal, "") && !Objects.equals(mailVal, "") && !Objects.equals(phoneVal, "") && !Objects.equals(cityVal, "") && !Objects.equals(passwordVal, "")) {
// Instantiate the RequestQueue.
            RequestQueue queue = Volley.newRequestQueue(this);
            //string of url which refers to the php code
            String url = "http://192.168.225.44/helpr/helprregister.php?name=" + nameVal + "&mail=" + mailVal + "&phone=" + phoneVal + "&city=" + cityVal + "&password=" + passwordVal;

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
                                Toast.makeText(helprregister.this, "Registered!", Toast.LENGTH_LONG).show();
                                Intent userone=new Intent(getApplicationContext(),userone.class);
                                startActivity(userone);
                                finish();
                            } else {
                                Toast.makeText(helprregister.this, "Could not register!", Toast.LENGTH_LONG).show();
                            }
                        /*
                        try {

                            JSONObject mJSON=new JSONObject(response);
                            Boolean status = mJSON.getBoolean("success");
                            String id=mJSON.getString("name");
                            if(status)
                            {
                                                               }else{

                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        try {
                            JSONArray mjSON=new JSONArray(response);
                            for (int i=0;i<mjSON.length();i++)
                            {
                                JSONObject single=mjSON.getJSONObject(i);
                                String id=single.getString("id");
                                Log.e("ID",id);

                            }


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
*/
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });

// Add the request to the RequestQueue.
            queue.add(stringRequest);

        } else {
            Toast.makeText(helprregister.this, "You missed some field(s)!", Toast.LENGTH_LONG).show();
        }
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("helprregister Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }


}
