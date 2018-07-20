package com.example.akash.helprapp;


import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.os.EnvironmentCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Random;

import de.hdodenhof.circleimageview.CircleImageView;

import static android.content.ContentValues.TAG;


/**
 * A simple {@link Fragment} subclass.
 */
public class helprfragthree extends Fragment {
    private static final int CAMERA_REQUEST=1888;
    private static final int MY_CAMERA_PERMISSION_CODE=100;
    private CircleImageView obj2;
    ImageView camera;
    String fname;
    ImageView nexttofragfour;
    public helprfragthree() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView=inflater.inflate(R.layout.fragment_helprfragthree, container, false);
        Bundle b3=getArguments();
        final String animal=b3.getString("animal");
        final Double latitude=b3.getDouble("latitude");
        final Double longitude=b3.getDouble("longitude");
        String str="Animal: "+animal+" latitude: "+latitude+" longitude: "+longitude;
        Toast.makeText(getContext(),str,Toast.LENGTH_LONG).show();
        camera=(ImageView)rootView.findViewById(R.id.cameralaunch);
        nexttofragfour=(ImageView)rootView.findViewById(R.id.nextbuttontofragfour);
        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getContext().checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                    requestPermissions(new String[]{Manifest.permission.CAMERA}, MY_CAMERA_PERMISSION_CODE);
                } else {
                    Intent obj3 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(obj3, CAMERA_REQUEST);
                }
            }
        });
        this.obj2=(CircleImageView)rootView.findViewById(R.id.animalphoto);
        nexttofragfour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Bundle helprbundlethree=new Bundle();
                    helprbundlethree.putString("animal",animal);
                    helprbundlethree.putDouble("latitude",latitude);
                    helprbundlethree.putDouble("longitude",longitude);
                    helprbundlethree.putString("imageurl",fname);
                    FragmentManager fragmentManager=getActivity().getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                    helprfragfour four=new helprfragfour();
                    four.setArguments(helprbundlethree);
                    fragmentTransaction.replace(R.id.frameuserone,four);
                    fragmentTransaction.commit();
            }
        });
        return rootView;
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults)
    {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(grantResults[0]==PackageManager.PERMISSION_GRANTED)
        {
            Intent obj=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(obj,CAMERA_REQUEST);
        }
        else
        {
            Toast.makeText(getContext(),"camera permission denied!",Toast.LENGTH_LONG).show();
        }
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if(requestCode==CAMERA_REQUEST && resultCode== Activity.RESULT_OK)
        {
            Bitmap pic=(Bitmap)data.getExtras().get("data");
            obj2.setImageBitmap(pic);
            String root = Environment.getExternalStorageDirectory().toString();
            File myDir = new File(root + "/req_images");
            myDir.mkdirs();
            Random generator = new Random();
            int n = 10000;
            n = generator.nextInt(n);
            fname= "Image-" + n + ".jpg";
            File file = new File(myDir, fname);
            Log.i(TAG, "" + file);
            if (file.exists())
                file.delete();
            try {
                FileOutputStream out = new FileOutputStream(file);
                pic.compress(Bitmap.CompressFormat.JPEG, 90, out);
                out.flush();
                out.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}

