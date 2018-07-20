package com.example.akash.helprapp;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.LinkedHashSet;


/**
 * A simple {@link Fragment} subclass.
 */
public class helprfragone extends Fragment {
    CheckBox checkdog,checkcat,checkcow,checkbird;
    String str;
    ImageView buttonfragtwo;
    public helprfragone() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView= inflater.inflate(R.layout.fragment_helprfragone, container, false);
        checkdog=(CheckBox)rootView.findViewById(R.id.checkBoxDog);
        checkcat=(CheckBox)rootView.findViewById(R.id.checkBoxCat);
        checkcow=(CheckBox)rootView.findViewById(R.id.checkBoxCow);
        checkbird=(CheckBox)rootView.findViewById(R.id.checkBoxBird);
        buttonfragtwo=(ImageView)rootView.findViewById(R.id.helprfragtwobutton);
        checkdog.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(checkcat.isChecked())checkcat.toggle();
                if(checkcow.isChecked())checkcow.toggle();
                if(checkbird.isChecked())checkbird.toggle();
                str=checkdog.getText().toString();
            }
        });
        checkcat.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(checkdog.isChecked())checkdog.toggle();
                if(checkcow.isChecked())checkcow.toggle();
                if(checkbird.isChecked())checkbird.toggle();
                str=checkcat.getText().toString();
            }
        });
        checkcow.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(checkdog.isChecked())checkdog.toggle();
                if(checkcat.isChecked())checkcat.toggle();
                if(checkbird.isChecked())checkbird.toggle();
                str=checkcow.getText().toString();
            }
        });
        checkbird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkdog.isChecked())checkdog.toggle();
                if(checkcow.isChecked())checkcow.toggle();
                if(checkcat.isChecked())checkcat.toggle();
                str=checkbird.getText().toString();
            }
        });
            buttonfragtwo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getContext(),str,Toast.LENGTH_SHORT).show();
                 Bundle bundle=new Bundle();
                    bundle.putString("animal",str);
                FragmentManager fragmentManager=getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                helprfragtwo two=new helprfragtwo();
                two.setArguments(bundle);
                 fragmentTransaction.replace(R.id.frameuserone,two);
                    fragmentTransaction.commit();
                    }
            });
    return rootView;
    }

}
