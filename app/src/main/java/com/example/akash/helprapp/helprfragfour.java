package com.example.akash.helprapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class helprfragfour extends Fragment {

    ImageView submit;
    String output;
    public helprfragfour() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View rootView= inflater.inflate(R.layout.fragment_helprfragfour, container, false);
        Bundle b3=getArguments();
        submit=(ImageView)rootView.findViewById(R.id.submithelpr);
        final String animal=b3.getString("animal");
        final Double latitude=b3.getDouble("latitude");
        final Double longitude=b3.getDouble("longitude");
        final String imageurl=b3.getString("imageurl");
        output="animal : "+animal+" latitude : "+latitude+" longitude : "+longitude+" imageurl : "+imageurl;
        submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"Thanks for helping!",Toast.LENGTH_LONG).show();
                FragmentManager fragmentManager=getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                helprfragone one=new helprfragone();
                //The data should be put in database here
                fragmentTransaction.replace(R.id.frameuserone,one);
                fragmentTransaction.commit();
            }
        });
        return rootView;
    }

}
