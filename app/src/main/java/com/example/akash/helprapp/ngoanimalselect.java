package com.example.akash.helprapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class ngoanimalselect extends AppCompatActivity {
    private CheckBox checkdog,checkcat,checkcow,checkbird;
    String str;
    ArrayList<String> obj=new ArrayList<String>();
    Set<String> obj2=new LinkedHashSet<String>(obj);
    Iterator<String> obj3;
    StringTokenizer obj4;
    int nid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ngoanimalselect);
        checkdog=(CheckBox)findViewById(R.id.checkBoxDog);
        checkcat=(CheckBox)findViewById(R.id.checkBoxCat);
        checkcow=(CheckBox)findViewById(R.id.checkBoxCow);
        checkbird=(CheckBox)findViewById(R.id.checkBoxBird);
    }
    public void fun(View view)
    {
        str="";
        switch(view.getId())
        {
            case R.id.checkBoxDog:if(checkdog.isChecked()) {
                str = checkdog.getText().toString();
                obj.add(str);
            }
                break;
            case R.id.checkBoxCat:if(checkcat.isChecked()) {
                str = checkcat.getText().toString();
                obj.add(str);
            }
                break;
            case R.id.checkBoxCow:if(checkcow.isChecked()) {
                str = checkcow.getText().toString();
                obj.add(str);
            }
                break;
            case R.id.checkBoxBird:if(checkbird.isChecked()) {
                str = checkbird.getText().toString();
                obj.add(str);
            }
                break;
        }
        obj2=new LinkedHashSet<String>(obj);

    }
    public void submitanimal(View view){
        obj3=obj2.iterator();
        String str="",str2="";
        while(obj3.hasNext())
        {
            str=str+obj3.next()+" ";
        }
        obj4=new StringTokenizer(str);
        int a=obj4.countTokens();
        int i=0;

        Toast.makeText(ngoanimalselect.this,str,Toast.LENGTH_LONG).show();
        //TextView ab=(TextView)findViewById(R.id.textView10);
        //ab.setText(str);
        Bundle bundle = getIntent().getExtras();
        String mailVal = bundle.getString("mailVal");
        Toast.makeText(ngoanimalselect.this,mailVal,Toast.LENGTH_SHORT).show();
        RequestQueue queue = Volley.newRequestQueue(this);
        //string of url which refers to the php code
        String url = "http://192.168.225.44/helpr/fetchngoid.php?mail="+mailVal;

// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        nid=Integer.parseInt(response);
                        Toast.makeText(ngoanimalselect.this,response,Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
// Add the request to the RequestQueue.
        queue.add(stringRequest);


        while(i<a)
        {
            str2=obj4.nextToken();
            RequestQueue animalqueue = Volley.newRequestQueue(this);
            String s1=Integer.toString(nid);
            //string of url which refers to the php code
            String animalurl = "http://192.168.225.44/helpr/addanimal.php?nid="+s1+"&animal"+str2;

// Request a string response from the provided URL.
            StringRequest abc = new StringRequest(Request.Method.GET, animalurl,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            // Display the first 500 characters of the response string.
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                }
            });
// Add the request to the RequestQueue.
            animalqueue.add(abc);
        }
        Intent ngoone=new Intent(getApplicationContext(),ngohome.class);
        startActivity(ngoone);
        finish();
    }
}
