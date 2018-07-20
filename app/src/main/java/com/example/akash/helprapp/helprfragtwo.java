package com.example.akash.helprapp;


import android.content.Context;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import im.delight.android.location.SimpleLocation;

/**
 * A simple {@link Fragment} subclass.
 */
public class helprfragtwo extends Fragment {
    ImageView locate;
    TextView currentlocation;
    ImageView next;
    String address;
    Double latitude;
    Double longitude;
    private SimpleLocation location;
    public helprfragtwo() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView= inflater.inflate(R.layout.fragment_helprfragtwo,container,false);
        locate=(ImageView)rootView.findViewById(R.id.buttonlocate);
        next=(ImageView)rootView.findViewById(R.id.nextbuttontofragthree);
        currentlocation=(TextView)rootView.findViewById(R.id.mylocation);
        Bundle b2=getArguments();
        final String animal=b2.getString("animal");
        locate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                location=new SimpleLocation(getContext());
                if(!location.hasLocationEnabled()){
                    SimpleLocation.openSettings(getContext());
                }
                latitude=location.getLatitude();
                longitude=location.getLongitude();
                address=getAddressFromLatLng(latitude,longitude);
                Toast.makeText(getContext(),address,Toast.LENGTH_SHORT).show();
                currentlocation.setText(address);
                /*
                Bundle helprbundletwo=new Bundle();
                helprbundletwo.putString("animalselected", animal);
                FragmentManager fragmentManager=getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                helprfragthree three=new helprfragthree();
                three.setArguments(helprbundletwo);
                fragmentTransaction.replace(R.id.frameuserone,new helprfragthree());
                fragmentTransaction.commit();
                */
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (address.length() != 0) {
                    Bundle helprbundletwo=new Bundle();
                    helprbundletwo.putString("animal",animal);
                    helprbundletwo.putDouble("latitude",latitude);
                    helprbundletwo.putDouble("longitude",longitude);
                    FragmentManager fragmentManager=getActivity().getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                    helprfragthree three=new helprfragthree();
                    three.setArguments(helprbundletwo);
                    fragmentTransaction.replace(R.id.frameuserone,three);
                    fragmentTransaction.commit();
                }else {
                    Toast.makeText(getContext(),"Press Locate Button!",Toast.LENGTH_SHORT).show();
                }
            }
        });
        return rootView;
    }
    private String getAddressFromLatLng(double latitude,double longitude)
    {
        Geocoder geocoder=new Geocoder(getContext());
        String address="";
        try{
            address=geocoder.getFromLocation(latitude,longitude,1).get(0).getAddressLine(0);
        }catch (Exception e) {
        }
        return address;
    }


}
